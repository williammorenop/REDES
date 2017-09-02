package Controller;

import java.util.StringTokenizer;
import jpcap.Packet;

public class TramaARP extends Packet {
  public static final short ETHERNET_TYPE= 1;
  public static final short IEEE802_TYPE = 6;
  public static final short  FREAMERELAY_TYPE =  15;
  public static final short TYPE_PROTOCOL = 2048;
   public static final short ARP_REQUEST = 1;
   public static final short ARP_REPLY = 2;
   public static final short RARP_REQUEST = 3;
   public static final short RARP_REPLY = 3;
  private short hardwareType;
  private short typeProtocol;
  private short hardwareAddressLenght;
  private short ipAddressLenght;
  private short operation;
  private byte[] senderHardwareAddress;
  private byte[] senderIpAddress;
  private byte[] targetHardwareAddress;
  private byte[] targetIpAddress;
  private short MAX_LENGHT = 6;


  //Cuando llega en string
  public void setSenderHardwareAddress(String _senderHardwareAddress)
  {
    StringTokenizer tokens = new StringTokenizer(_senderHardwareAddress, ":");
    senderHardwareAddress = new byte[MAX_LENGHT];
    int pos = 0;
    while( tokens.hasMoreElements() )
    {
      senderHardwareAddress[ pos ] = oonvertString(tokens.nextElement());;
      pos++;
    }
  }
  private byte castChar( char a )
  {
    if( a >= '0' && a < 10 )
      return a-'0';
    return (a-'a')+10;
  }
  private byte converStrin( String hex )
  {
    char left = hex[ 0 ];
    char right = hex[ 1 ];
    return (castChar( left )<<4)|castChar(left);
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
    return hexUpperChar(n)+hexLowerChar(n);
  }
  public String[] getSenderHardwareAdrresString()
  {
    String[] ret = new String[hardwareAddressLenght];
    for( int i = 0  ; i < hardwareAddressLenght ; ++i )
    {
      ret[ i ] = harToString(senderHardwareAddress[i]);
    }
  }
  public String[] getTargetHardwareAdrresString()
  {
    String[] ret = new String[hardwareAddressLenght];
    for( int i = 0  ; i < hardwareAddressLenght ; ++i )
    {
      ret[ i ] = harToString(TragetHardwareAddress[i]);
    }
  }
  public String toString() {
        String buf="";

        switch (operation) {
            case ARP_REQUEST:
                buf.append("ARP REQUEST ");
                break;
            case ARP_REPLY:
                buf.append("ARP REPLY ");
                break;
            case RARP_REQUEST:
                buf.append("RARP REQUEST ");
                break;
            case RARP_REPLY:
                buf.append("RARP REPLY ");
                break;
            default:
                buf.append("UNKNOWN ");
                break;
        }

        return buf.toString() ;
    }

}
