import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;


public class ARP {
	static List<String> ips = new ArrayList<String>();
	static List<String> macs = new ArrayList<String>();
	static NetworkInterface myDevice;
	static InetAddress pip;
	
	/*public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("1");

		request(TramaARP.HARDTYPE_ETHER, "", "", "192.168.0.2");
	}*/
	
	private static void maceipPropia(InetAddress ip)
	{
		NetworkInterface[] devices=JpcapCaptor.getDeviceList();
		System.out.println(devices);
		NetworkInterface device=null;
		
loop:	for(NetworkInterface d:devices){
			for(NetworkInterfaceAddress addr:d.addresses){
				System.out.println(addr);
				if(!(addr.address instanceof Inet4Address)) continue;
				System.out.println("hola "+addr.address+" "+addr.subnet);
				
				byte[] bip=ip.getAddress();
				byte[] subnet=addr.subnet.getAddress();
				byte[] bif=addr.address.getAddress();
				for(int i=0;i<4;i++){
					bip[i]=(byte)(bip[i]&subnet[i]);
					bif[i]=(byte)(bif[i]&subnet[i]);
				}
				if(Arrays.equals(bip,bif)){//
					System.out.println("--"+bip[2]+" "+bif[2]+" " );
					device=d;
					System.out.println("Empieza");
					for( NetworkInterfaceAddress adr :device.addresses)
					{
						System.out.println(adr.address);
					}
					break loop;
				}
			}
		}
		
		if(device==null)
			throw new IllegalArgumentException(ip+" is not a local address");
		InetAddress srcip=null;
		for(NetworkInterfaceAddress addr:device.addresses)
			if(addr.address instanceof Inet4Address){
				srcip=addr.address;
				System.out.println(srcip);
				break;
			}
		myDevice = device;
		pip = srcip;
		System.out.println("salgo");
	}
	public static   ARPPacket request(short typeH,String originMAC,String originIP,String destiniIP ) throws IOException
	{
		TramaARP arp = new TramaARP();
		InetAddress target = InetAddress.getByName(destiniIP);
		if(  pip == null )
			maceipPropia(target);
		
		JpcapCaptor captor=JpcapCaptor.openDevice(myDevice,2000,false,3000);
		captor.setFilter("arp",true);//
		JpcapSender sender=captor.getJpcapSenderInstance(); //
		InetAddress origin ;
		if( originIP.equals("") )
			origin = pip;
		else
			origin = InetAddress.getByName(originIP);
		byte[] mac = null;
		if( originMAC.equals("") )
			mac = myDevice.mac_address;
		arp.llenar(typeH, mac, origin, target);
		if( !originMAC.equals("") )
			arp.setSender_hardaddr(originMAC);
		
		
		EthernetPacket ether=new EthernetPacket();
		ether.frametype=EthernetPacket.ETHERTYPE_ARP;
		ether.src_mac=arp.sender_hardaddr;
		ether.dst_mac=TramaARP.broadcast;
		arp.datalink=ether;
		sender.sendPacket(arp);
		
		while(true){
			ARPPacket p=(ARPPacket)captor.getPacket();
			System.out.println(p.toString()+"\n");
			if(p==null){
				throw new IllegalArgumentException(origin+" is not a local address");
			}
			if(Arrays.equals(p.target_protoaddr,pip.getAddress())){
				boolean elbool=false;
				
				for (int i = 0; i < macs.size(); i++) {
					if(macs.get(i).equals(p.getSenderHardwareAddress().toString())&&ips.get(i).equals(p.getSenderProtocolAddress().toString()))
					{
						elbool=true;
						break;
					}
					
				}
				if (!elbool) {
					
					macs.add(p.getSenderHardwareAddress().toString());
					ips.add(p.getSenderProtocolAddress().toString());					
				}
				elbool = false;
				for (int i = 0; i < macs.size(); i++) {
					if(macs.get(i).equals(p.getTargetHardwareAddress().toString())&&ips.get(i).equals(p.getTargetProtocolAddress().toString()))
					{
						elbool=true;
						break;
					}
					
				}
				if (!elbool) {
					
					macs.add(p.getTargetHardwareAddress().toString());
					ips.add(p.getTargetProtocolAddress().toString());					
				}
				for (int i = 0; i < macs.size(); i++) {
					System.out.println(macs.get(i) + "--->"+ ips.get(i)+"\n");
					
				}
				
				return   p;
			}
		}
		
	}
	
	
}
