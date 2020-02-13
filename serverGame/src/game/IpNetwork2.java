/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package game;

//import java.io.*;
import java.net.*;
import java.util.*;
//import static java.lang.System.out;
/**
 *
 * @author safaa
 */
public class IpNetwork2 {
    
    
    static int i=68;
    static InetAddress addresses;
    static int count=0;
    byte[] ip=null;
    
    public InetAddress getNextAddress()
    {
            return addresses;
    }


	IpNetwork2() {
	      
	    try {
		ip = GetExternalIp();
		System.out.println("myIp: "+InetAddress.getByAddress(ip).toString());
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	}


public byte[] GetExternalIp()throws SocketException{
	byte[] ip=null;
        Enumeration e;
	
        e = NetworkInterface.getNetworkInterfaces();    //interface generates a series of elements
                                                        //NetworkInterface represents a Network Interface made up of a name, and a 									      list of IP addresses assigned to this interface.
                                                            /*fe80:0:0:0:98d8:ca1e:d8dd:bc1c%wlp2s0
                                                            192.168.1.6
                                                            0:0:0:0:0:0:0:1%lo
                                                            127.0.0.1*/
	
	NetworkInterface n = (NetworkInterface) e.nextElement();
	Enumeration ee = n.getInetAddresses();
	if (ee.hasMoreElements())
	{
            InetAddress i = (InetAddress) ee.nextElement();
            i = (InetAddress) ee.nextElement();
	   try{
		ip = i.getAddress();
	    	System.out.println(InetAddress.getByAddress(ip));
		
	    } catch (Exception ex) {
		ex.printStackTrace();     
	    }
	}
	return ip;

    }

    boolean checkIp()
    {
        final int j = i; 
        i++; 
        try {
            ip[3] = (byte)j;
            InetAddress address = InetAddress.getByAddress(ip);
            String output = address.toString().substring(1);
                addresses=address;
                System.out.println(address.isReachable(300) + " is time reachable "+ output);
            if (address.isReachable(300)) {
                addresses=address;
                System.out.println(output + " is on the network");
                return true;

            } 
        } catch (Exception e) {
                System.out.println("problem");
            e.printStackTrace();
        }
        return false;
    }

}
    
