/*		
	
	
		
			************************this code is for machine second****************************
*/



import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatServer2 implements Runnable
{		

		public void run()
		{

		try{	
			ServerSocket server2 = new ServerSocket(7777);		// server started and waiting for connection
			System.out.println("****************	Waiting for the Connection	****************");
			Socket client2 = server2.accept();		// server accept the cliecnt request
			System.out.println("Connection established");

			DataInputStream din = new DataInputStream(client2.getInputStream());		//object for input on server
			DataOutputStream dout = new DataOutputStream(client2.getOutputStream());	//object for output data on server

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //object for taking input from user

			String msgin="",msgout="";
			while(!msgin.equals("exit"))
			{	
				msgin=din.readUTF();
				System.out.println("[Server] : "+msgin);
				//System.out.print("[Server] : ");
				//msgout = br.readLine();
				//dout.writeUTF(msgout);
				//dout.flush();
			}
			
			client2.close();
			}
				catch(Exception e)
				{
					System.out.println("****************	session end	****************");
				}
		
		}
	}

class ChatClient2 implements Runnable
{		
	public void run()
	{	
		try
		{
			//try{Thread.sleep(5000);}catch(Exception e){}			//delay for request of client and server
			Socket client2 = new Socket("localhost",6666);		//client request to particular server
			System.out.println("Connection established");
			DataInputStream din = new DataInputStream(client2.getInputStream());
			DataOutputStream dout = new DataOutputStream(client2.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //object for taking input from user
			String msgin="",msgout="";
		
			while(!msgin.equals("exit"))
			{	System.out.println("[Client] : ");
				msgout = br.readLine();
				dout.writeUTF(msgout);
				//msgin = din.readUTF();
				//System.out.println("[Server] : "+msgin);
			}			
	
		}
			catch(Exception e)
			{
				System.out.println("Wrong port number. please try again later");
			}
	}
 } 
 
 class ChatThread2
 {
 	public static void main(String[] args) throws Exception
 	{	
 		Runnable th1 = new ChatServer2();	//object of server class
 		Runnable th2 = new ChatClient2();	//object of client class

 		Thread t1 = new Thread(th1);		//thread allocated to server
 		Thread t2 = new Thread(th2);		//thread alllocated to client
 		
 		t1.start();
 		t2.start();
 		
 		
 	}
 }
