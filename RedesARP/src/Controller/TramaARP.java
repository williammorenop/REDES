package Controller;

import java.util.StringTokenizer;

import jpcap.packet.Packet;

public class TramaARP extends Packet {
  private static final long serialVersionUID = 3271911802471786372L;
  public static final short HARDTYPE_ETHER= 1;
  public static final short HARDTYPE_IEEE802 = 6;
  public static final short  HARDTYPE_FRAMERELAY =  15;
  public static final short TYPE_PROTOCOL = 2048;
   public static final short ARP_REQUEST = 1;
   public static final short ARP_REPLY = 2;
   public static final short RARP_REQUEST = 3;
   public static final short RARP_REPLY = 4;
   public short hardtype;
  private short prototype;
  public short hlen;
  public short plen;
  public short operation;
  public byte[] sender_hardaddr;
  public byte[] sender_protoaddr;
  public byte[] target_hardaddr;
  public byte[] target_protoaddr;
  public short MAX_LENGHT = 6;

  //Cuando llega en string
  public void setSender_hardaddr(String _sender_hardaddr)
  {
    StringTokenizer tokens = new StringTokenizer(_sender_hardaddr, ":");
    sender_hardaddr = new byte[MAX_LENGHT];
    int pos = 0;
    while( tokens.hasMoreElements() )
    {
      sender_hardaddr[ pos ] = convertString(tokens.nextElement().toString());;
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
    String[] ret = new String[hlen];
    for( int i = 0  ; i < hlen ; ++i )
    {
      ret[ i ] = harToString(sender_hardaddr[i]);
    }
    return ret;
  }
  public String[] getTargetHardwareAdrresString()
  {
    String[] ret = new String[hlen];
    for( int i = 0  ; i < hlen ; ++i )
    {
      ret[ i ] = harToString(target_hardaddr[i]);
    }
    return ret;
  }

  /**
 * @return the hardtype
 */
public short getHardtype() {
	return hardtype;
}
/**
 * @param hardtype the hardtype to set
 */
public void setHardtype(short hardtype) {
	this.hardtype = hardtype;
}
/**
 * @return the prototype
 */
public short getPrototype() {
	return prototype;
}
/**
 * @param prototype the prototype to set
 */
public void setPrototype(short prototype) {
	this.prototype = prototype;
}
/**
 * @return the hlen
 */
public short getHlen() {
	return hlen;
}
/**
 * @param hlen the hlen to set
 */
public void setHlen(short hlen) {
	this.hlen = hlen;
}
/**
 * @return the plen
 */
public short getPlen() {
	return plen;
}
/**
 * @param plen the plen to set
 */
public void setPlen(short plen) {
	this.plen = plen;
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
 * @return the sender_hardaddr
 */
public byte[] getSender_hardaddr() {
	return sender_hardaddr;
}
/**
 * @param sender_hardaddr the sender_hardaddr to set
 */
public void setSender_hardaddr(byte[] sender_hardaddr) {
	this.sender_hardaddr = sender_hardaddr;
}
/**
 * @return the sender_protoaddr
 */
public byte[] getSender_protoaddr() {
	return sender_protoaddr;
}
/**
 * @param sender_protoaddr the sender_protoaddr to set
 */
public void setSender_protoaddr(byte[] sender_protoaddr) {
	this.sender_protoaddr = sender_protoaddr;
}
/**
 * @return the target_hardaddr
 */
public byte[] getTarget_hardaddr() {
	return target_hardaddr;
}
/**
 * @param target_hardaddr the target_hardaddr to set
 */
public void setTarget_hardaddr(byte[] target_hardaddr) {
	this.target_hardaddr = target_hardaddr;
}
/**
 * @return the target_protoaddr
 */
public byte[] getTarget_protoaddr() {
	return target_protoaddr;
}
/**
 * @param target_protoaddr the target_protoaddr to set
 */
public void setTarget_protoaddr(byte[] target_protoaddr) {
	this.target_protoaddr = target_protoaddr;
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
