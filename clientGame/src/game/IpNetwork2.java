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
    
    
    static int i=1;
    //static List<InetAddress> addresses = new ArrayList<>();
    static InetAddress addresses;
    static int count=0;

    public InetAddress getNextAddress()
    {
            return addresses;
    }


	IpNetwork2() {
	      byte[] ip=null;
	    try {
		ip = GetExternalIp();
		System.out.println("myIp: "+InetAddress.getByAddress(ip).toString());
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    //for(int n=1;n<=254;n++) {
	    //for(int i=1;i<=10;i++) 
		{
		final int j = i; 
		i++; 
		//final int m = n;  
		//new Thread(new Runnable() {   // new thread for parallel execution
		    //public void run() 
			{
		        try {
		            ip[3] = (byte)j;
		            //ip[2] = (byte)m;
		            InetAddress address = InetAddress.getByAddress(ip);
		            String output = address.toString().substring(1);
				addresses=address;
//		                System.out.println(address.isReachable(300) + " is time reachable "+ output);
		            if (address.isReachable(300)) {
				//addresses.add(address);
				addresses=address;
		                System.out.println(output + " is on the network");
				
		            } 
		        } catch (Exception e) {
		                System.out.println("problem");
		            e.printStackTrace();
		        }
		    }
		//}).start();     
		}
	    //}
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
		ex.printStackTrace();     // exit method, otherwise "ip might not have been initialized"
	    }
	}
	return ip;

    }

}
