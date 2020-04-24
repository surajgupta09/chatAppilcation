/*	
			****************** this code is for machine first **************************

*/






import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatServer1 implements Runnable
{		

		public void run()
		{

		try{	
			ServerSocket server1 = new ServerSocket(6666);	//server socket connection req
			System.out.println("****************	Waiting for the Connection	****************");
			Socket client1 = server1.accept();	//server accept the client request
			System.out.println("Connection established");

			DataInputStream din = new DataInputStream(client1.getInputStream());	
			DataOutputStream dout = new DataOutputStream(client1.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//object creation for input

			String msgin="",msgout="";
			while(!msgin.equals("exit"))		//logic for msg send and recieve
			{	
				msgin=din.readUTF();
				System.out.println("[Client] : "+msgin);
				//System.out.print("[Server] : ");
				//msgout = br.readLine();
				//dout.writeUTF(msgout);
				//dout.flush();
			}
			
			client1.close();	//resourse deallocated
			}
				catch(Exception e)
				{
					System.out.println("****************	session end	****************");
				}
		
		}
	}

class ChatClient1 implements Runnable
{		
	public void run()
	{	
		try
		{		
			
			try{Thread.sleep(5000);}catch(Exception e){}	//delay in between server and client requests
			Socket client1 = new Socket("localhost",7777);	//client send connection request to server
			System.out.println("Connection established");
			DataInputStream din = new DataInputStream(client1.getInputStream());	//data input object creation
			DataOutputStream dout = new DataOutputStream(client1.getOutputStream());	//data output object creation

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//object for taking input from user
			String msgin="",msgout="";
		
			while(!msgin.equals("exit"))
			{	System.out.println("[Server] : ");
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

 class ChatThread1
 {
 	public static void main(String[] args) throws Exception
 	{
 		Runnable th1 = new ChatServer1();		//object of server class
 		Runnable th2 = new ChatClient1();		//object of client class
 		
 		Thread t1 = new Thread(th1);			//thread allocated to server object
 		Thread t2 = new Thread(th2);			//thread allocated to client object
 		
 		t1.start();		//thread called for force start
 		t2.start();
 		
 	}
 }
