/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
/**
 *
 * @author safaa
 */
public class Client {
    
    
	Socket mySocket;
	BufferedReader dis;
	//DataInputStream dis ;
	PrintStream ps;
	String checkConnection="";
                
	char[] XO={0};
	int turn=1;
        
        int win=0;
        int tie=0;
        
        
        void useLogicX(int i)
        {
            
        }
        void useLogicO(int i)
        {
            
        }
        
        
        TwoOffline twooffline ;
	Client()
	{
//            while(!checkConnection.equals("player1"))
            {
                checkConnection="";
                try
                {
//                    IpNetwork2 ip = new IpNetwork2();
                    mySocket = new Socket(InetAddress.getLocalHost(), 5665);
//                    mySocket = new Socket(ip.getNextAddress(), 5665);

                    mySocket.setSoTimeout(1000);
                    dis = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
                    ps = new PrintStream(mySocket.getOutputStream()); 

                    ps.println("player2");
                    checkConnection = dis.readLine();
                    if(checkConnection==null)
                    {
                        close();
                        checkConnection="";
                    }
                }
                catch(IOException ex)
                {
                    System.out.println("connection Exception");
                }
            }
            System.out.println("client is connected to : "+checkConnection);

            try 
            {
                mySocket.setSoTimeout(100000);
            } catch (SocketException ex) {
                System.err.println("TimeOut");;
            }

            try
            {
                twooffline = new TwoOffline();
                ReadMsg th = new ReadMsg();
                th.start();
            }
            catch (IllegalThreadStateException e)
            {
                System.out.println("thread client exception");
            }
	}

	class ReadMsg extends Thread
	{
            public void run()
            {
                int i;
                while(true)
                {
                    i=yourTurn();
                    if(i==99)
                    {
                        System.out.println("server is down");
                        close(); 
                        break;
                    }
                    else if (i!=88)
                    {
                        System.out.println("client Done ur_turn");
                    }
                }
            }
	}

	public void myTurn(int num)
	{
            if(turn==0)
            {
                System.out.println("send");
                if(twooffline.start(num))
                {
                    Platform.runLater(() ->useLogicO(num));
                    if(twooffline.win!=0)
                    {
                        win=1;
                    }
                    else
                    {
                        tie=1;
                    }
                    ps.println(num);
                    turn =1;
                }
            }
	}

	int yourTurn() 
	{
            int index=88;
            System.out.print("");
            if(turn==1) 
            {
                try
                {
                    System.out.println("receive");
                    String readMsg = dis.readLine();
                    if(readMsg!=null)
                    {
                        final int indexFinal = Integer.parseInt(readMsg);
                        index = indexFinal;
                        System.out.println("client received=> "+ index);
                        if(twooffline.start(index))
                        {

                            Platform.runLater(() ->useLogicX(indexFinal));
                            if(twooffline.win!=0)
                            {
                                win=1;
                            }
                            else
                            {
                                tie=1;
                            }
                            turn =0;
                            System.out.println("");
                        }
                        //System.out.println(index);
                    }
                    else if(readMsg==null) index=99;
                }
                catch(IOException e)
                {
                    System.out.println("server is down!!");
                    index=99;
                    close();
                    e.printStackTrace();
                    //System.exit(0);
                }
        }
            return index;
	}

	void close()
	{

		try
		{
                    ps.close();
                    dis.close();
                    mySocket.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    
}
