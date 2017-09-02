package Controller;

import java.util.StringTokenizer;

import jpcap.packet.Packet;

public class TramaARP extends Packet {
  public static final short ETHERNET_TYPE= 1;
  public static final short IEEE802_TYPE = 6;
  public static final short  FREAMERELAY_TYPE =  15;
  public static final short TYPE_PROTOCOL = 2048;
   public static final short ARP_REQUEST = 1;
   public static final short ARP_REPLY = 2;
   public static final short RARP_REQUEST = 3;
   public static final short RARP_REPLY = 4;
private short typeProtocol;
  public short hardwareAddressLenght;
  public short ipAddressLenght;
  public short operation;
  public byte[] senderHardwareAddress;
  public byte[] senderIpAddress;
  public byte[] targetHardwareAddress;
  public byte[] targetIpAddress;
  public short hardwareType;
  public short MAX_LENGHT = 6;

  //Cuando llega en string
  public void setSenderHardwareAddress(String _senderHardwareAddress)
  {
    StringTokenizer tokens = new StringTokenizer(_senderHardwareAddress, ":");
    senderHardwareAddress = new byte[MAX_LENGHT];
    int pos = 0;
    while( tokens.hasMoreElements() )
    {
      senderHardwareAddress[ pos ] = convertString(tokens.nextElement().toString());;
      pos++;
    }
  }
  private byte castChar( char a )
  {
    if( a >= '0' && a < 10 )
      return (byte) (a-'0');
    return (byte) ((a-'a')+10);
  }
  private byte convertString( String hex )
  {
    char left = hex.charAt(0);
    char right = hex.charAt(1) ;
    return (byte) ((castChar( left )<<4)|castChar(left));
  }
  //------------------
  private char hexUpperChar(byte b) {
        b = (byte) ((b >> 4) & 0xf);
        if (b == 0) return '0';
        else if (b < 10) return (char) ('0' + b);
        else return (char) ('a' + b - 10);


    }

    private char hexLowerChar(byte b) {
        b = (byte) (b & 0xf);

        if (b == 0) return '0';

        else if (b < 10) return (char) ('0' + b);

        else return (char) ('a' + b - 10);
    }
  private String harToString( byte n )
  {
    return String.valueOf(hexUpperChar(n))+String.valueOf(hexLowerChar(n));
  }
  public String[] getSenderHardwareAdrresString()
  {
    String[] ret = new String[hardwareAddressLenght];
    for( int i = 0  ; i < hardwareAddressLenght ; ++i )
    {
      ret[ i ] = harToString(senderHardwareAddress[i]);
    }
    return ret;
  }
  public String[] getTargetHardwareAdrresString()
  {
    String[] ret = new String[hardwareAddressLenght];
    for( int i = 0  ; i < hardwareAddressLenght ; ++i )
    {
      ret[ i ] = harToString(targetHardwareAddress[i]);
    }
    return ret;
  }
 
  /**
 * @return the hardwareType
 */
public short getHardwareType() {
	return hardwareType;
}
/**
 * @param hardwareType the hardwareType to set
 */
public void setHardwareType(short hardwareType) {
	this.hardwareType = hardwareType;
}
/**
 * @return the typeProtocol
 */
public short getTypeProtocol() {
	return typeProtocol;
}
/**
 * @param typeProtocol the typeProtocol to set
 */
public void setTypeProtocol(short typeProtocol) {
	this.typeProtocol = typeProtocol;
}
/**
 * @return the hardwareAddressLenght
 */
public short getHardwareAddressLenght() {
	return hardwareAddressLenght;
}
/**
 * @param hardwareAddressLenght the hardwareAddressLenght to set
 */
public void setHardwareAddressLenght(short hardwareAddressLenght) {
	this.hardwareAddressLenght = hardwareAddressLenght;
}
/**
 * @return the ipAddressLenght
 */
public short getIpAddressLenght() {
	return ipAddressLenght;
}
/**
 * @param ipAddressLenght the ipAddressLenght to set
 */
public void setIpAddressLenght(short ipAddressLenght) {
	this.ipAddressLenght = ipAddressLenght;
}
/**
 * @return the operation
 */
public short getOperation() {
	return operation;
}
/**
 * @param operation the operation to set
 */
public void setOperation(short operation) {
	this.operation = operation;
}
/**
 * @return the senderHardwareAddress
 */
public byte[] getSenderHardwareAddress() {
	return senderHardwareAddress;
}
/**
 * @param senderHardwareAddress the senderHardwareAddress to set
 */
public void setSenderHardwareAddress(byte[] senderHardwareAddress) {
	this.senderHardwareAddress = senderHardwareAddress;
}
/**
 * @return the senderIpAddress
 */
public byte[] getSenderIpAddress() {
	return senderIpAddress;
}
/**
 * @param senderIpAddress the senderIpAddress to set
 */
public void setSenderIpAddress(byte[] senderIpAddress) {
	this.senderIpAddress = senderIpAddress;
}
/**
 * @return the targetHardwareAddress
 */
public byte[] getTargetHardwareAddress() {
	return targetHardwareAddress;
}
/**
 * @param targetHardwareAddress the targetHardwareAddress to set
 */
public void setTargetHardwareAddress(byte[] targetHardwareAddress) {
	this.targetHardwareAddress = targetHardwareAddress;
}
/**
 * @return the targetIpAddress
 */
public byte[] getTargetIpAddress() {
	return targetIpAddress;
}
/**
 * @param targetIpAddress the targetIpAddress to set
 */
public void setTargetIpAddress(byte[] targetIpAddress) {
	this.targetIpAddress = targetIpAddress;
}
  public String toString() {
        String buf="";

        switch (operation) {
            case ARP_REQUEST:
                buf=("ARP REQUEST ");
                break;
            case ARP_REPLY:
                buf=("ARP REPLY ");
                break;
            case RARP_REQUEST:
                buf=("RARP REQUEST ");
                break;
            case RARP_REPLY:
                buf=("RARP REPLY ");
                break;
            default:
                buf=("UNKNOWN ");
                break;
        }

        return buf.toString() ;
    }

}
