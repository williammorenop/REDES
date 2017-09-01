import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

import jpcap.*;
import jpcap.packet.*;

public class ARP {
	public static byte[] arp(InetAddress ip) throws java.io.IOException{
		//find network interface
		NetworkInterface[] devices=JpcapCaptor.getDeviceList();
		System.out.println(devices);
		NetworkInterface device=null;
		
loop:	for(NetworkInterface d:devices){
			for(NetworkInterfaceAddress addr:d.addresses){
				System.out.println(addr);
				if(!(addr.address instanceof Inet4Address)) continue;
				System.out.println("hola "+addr.address+" "+addr.subnet);
				System.out.println("voy a compara con "+ip);
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
		
		//open Jpcap
		JpcapCaptor captor=JpcapCaptor.openDevice(device,2000,false,3000);
		captor.setFilter("arp",true);//
		JpcapSender sender=captor.getJpcapSenderInstance(); //
		
		InetAddress srcip=null;
		for(NetworkInterfaceAddress addr:device.addresses)
			if(addr.address instanceof Inet4Address){
				srcip=addr.address;
				System.out.println(srcip);
				break;
			}
////////////////////////////////////////////////////////////////////////
		byte[] broadcast=new byte[]{(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255};
		ARPPacket arp=new ARPPacket();
		arp.hardtype=ARPPacket.HARDTYPE_ETHER;
		arp.prototype=ARPPacket.PROTOTYPE_IP;
		arp.operation=ARPPacket.ARP_REQUEST;
		arp.hlen=6;
		arp.plen=4;
		arp.sender_hardaddr=device.mac_address;
		arp.sender_protoaddr=srcip.getAddress();
		arp.target_hardaddr=broadcast;
		arp.target_protoaddr=ip.getAddress();
		
		EthernetPacket ether=new EthernetPacket();
		ether.frametype=EthernetPacket.ETHERTYPE_ARP;
		ether.src_mac=device.mac_address;
		ether.dst_mac=broadcast;
		arp.datalink=ether;
		
		sender.sendPacket(arp);
	///////////////////////////////////////////////////////////////////
		while(true){
			ARPPacket p=(ARPPacket)captor.getPacket();
			System.out.println(p.toString()+"\n");
			if(p==null){
				throw new IllegalArgumentException(ip+" is not a local address");
			}
			if(Arrays.equals(p.target_protoaddr,srcip.getAddress())){
				return p.sender_hardaddr;
			}
		}
	}
		
	public static void main(String[] args) throws Exception{
		if(args.length<1){
			System.out.println("Usage: java ARP <ip address>");
		}else{
			byte[] mac=ARP.arp(InetAddress.getByName(args[0]));
			for (byte b : mac)
				System.out.print(Integer.toHexString(b&0xff) + ":");
			System.out.println();
			System.exit(0);
		}
	}
}