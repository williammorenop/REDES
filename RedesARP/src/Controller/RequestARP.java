/**
 * 
 */
package Controller;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Arrays;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;

/**
 * @author Miguel A Paez
 *
 */
public class RequestARP {

	public static TramaARP requestarp(InetAddress ip, String MACorigen, String HardType, String operation) throws java.io.IOException{
		//find network interface
		NetworkInterface[] listaipred=JpcapCaptor.getDeviceList();
		System.out.println(listaipred);
		NetworkInterface device=null;
		
loop:	for(NetworkInterface f:listaipred){
			for(NetworkInterfaceAddress direc:f.addresses){
				System.out.println(direc);
				if(!(direc.address instanceof Inet4Address)) continue;
				System.out.println("hola "+direc.address+" "+direc.subnet);
				System.out.println("voy a compara con "+ip);
				byte[] ipd=ip.getAddress();
				byte[] subnet=direc.subnet.getAddress();
				byte[] ipo=direc.address.getAddress();
				for(int i=0;i<4;i++){
					ipd[i]=(byte)(ipd[i]&subnet[i]);
					ipo[i]=(byte)(ipo[i]&subnet[i]);
				}
				if(Arrays.equals(ipd,ipo)){//
					System.out.println("--"+ipd[2]+" "+ipo[2]+" " );
					device=f;
					System.out.println("Empieza");
					for( NetworkInterfaceAddress dire :device.addresses)
					{
						System.out.println(dire.address);
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
		System.out.println("prumer flag");
		byte[] broadcast=new byte[]{(byte)255,(byte)255,(byte)255,(byte)255,(byte)255,(byte)255};
		TramaARP arp=new TramaARP();
		arp.setHardwareType(Short.parseShort(HardType));
		arp.setOperation(Short.parseShort(operation));
		arp.setHardwareAddressLenght(Short.valueOf((short) 6));
		arp.setIpAddressLenght(Short.valueOf((short)4));
		/*if(!MACorigen.equals("FF:FF:FF:FF:FF:FF")){
			arp.setSenderHardwareAddress(device.mac_address);
		}else{
			arp.setSenderHardwareAddress(MACorigen.getBytes());
		}*/
		arp.setSenderHardwareAddress(device.mac_address);
		arp.setSenderIpAddress(srcip.getAddress());
		arp.setTargetHardwareAddress(broadcast);
		arp.setTargetIpAddress(ip.getAddress());
		EthernetPacket ether=new EthernetPacket();
		ether.frametype=EthernetPacket.ETHERTYPE_ARP;
		ether.src_mac=device.mac_address;
		ether.dst_mac=broadcast;
	    arp.datalink=ether;
		System.out.println("Segundo flag");
		sender.sendPacket(arp);
	///////////////////////////////////////////////////////////////////
		System.out.println("tercer flah");
		while(true){
			TramaARP p=(TramaARP)captor.getPacket();
			System.out.println(p.toString()+"\n");
			if(p==null){
				throw new IllegalArgumentException(ip+" is not a local address");
			}
			if(Arrays.equals(p.getTargetIpAddress(),srcip.getAddress())){
				return p;
			}
		}
	}
		
	public static TramaARP recibirGUI(String MACorigen, String IPorigen,String MACdestino, String IPdestino,
			String HardType, String operation) throws Exception{
		if(IPdestino.length()<1){
			System.out.println("Usage: java ARP <ip address>");
		}else{
			return RequestARP.requestarp(InetAddress.getByName(IPdestino), MACorigen, HardType, operation);
		}
		return null;
	}
	public static void main(String[] args) throws Exception{
		
			System.out.println(recibirGUI("","","","192.168.0.2","1","1"));
			System.exit(0);
		
	}
}
