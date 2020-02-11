/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.net.*;
import java.io.*;
import javafx.application.Platform;
/**
 *
 * @author safaa
 */
public class Server {
    
    
	ServerSocket server;
	Socket c;
	BufferedReader input;
	PrintStream output;
	String checkConnection="";
	char[] XO={0};
	int turn=0;
        
        
        int win=0;
        int tie=0;
        
        void useLogicX(int i)
        {
            
        }
        void useLogicO(int i)
        {
            
        }
        
        
        TwoOffline twooffline ;

	Server()
	{
            while(!checkConnection.equals("player2"))
            {
                checkConnection="";
		try
                {
                    server = new ServerSocket(5665);
                    c = server.accept();
                    input = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    output = new PrintStream(c.getOutputStream()); 

                    checkConnection = input.readLine();
                    if(checkConnection.equals("player2"))
                    {
                        output.println("player1");
                    }
		}
		catch(IOException e)
		{
                    e.printStackTrace();
		}
            }
            System.out.println("server is connected to: "+checkConnection);
            
            try
            {
                twooffline = new TwoOffline();
                ReadMsg th = new ReadMsg();
                th.start();
            }
            catch (IllegalThreadStateException e)
            {
                System.out.println("thread server exception");
            }

	}

	class ReadMsg extends Thread
	{
            public void run()
            {
                int i=88;
                while(true)
                {
                    i = yourTurn();
                    if(i==99)
                    {
                        System.out.println("client closed");
                        close(); 
                        break;
                    }
                    else if (i!=88)
                    {
                        System.out.println("server Done ur_turn");
                    }
                }
            }
	}

	void myTurn(int num)
	{
            if(turn==0)
            {
                System.out.println("send");
                if(twooffline.start(num))
                {
                    Platform.runLater(() -> useLogicX(num));
                            System.out.println("server Done my_turn");
                    if(twooffline.win!=0)
                    {
                        win=1;
                    }
                    else
                    {
                        tie=1;
                    }
                    turn =1;
                    output.println(num);
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
                    String readMsg = input.readLine();
                    if(readMsg!=null)
                    {
                        final int indexFinal = Integer.parseInt(readMsg);
                        index = indexFinal;
                        System.out.println("server received=> "+ index);
                        if(twooffline.start(index))
                        {
                            Platform.runLater(() ->useLogicO(indexFinal));
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
                    }
                    else if(readMsg==null) index=99;
                }
                catch(IOException e)
                {
                    System.out.println("client closed!!");
                    index=99;
                    close();
//                  e.printStackTrace();
                    //System.exit(0);
                }
            }
            return index;
	}

	void close()
	{

		try
		{
                    output.close();
                    input.close();
                    c.close();
                    //System.exit(0);
		}
		catch(Exception ex)
		{
                    ex.printStackTrace();
		}
	}

    
}
