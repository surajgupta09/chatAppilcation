/*				
************************this code is for machine second****************************
*/
import java.io.*;
import java.net.*;
import java.util.Scanner;

class ChatServer2 implements Runnable {
	public void run() {
		try {
			ServerSocket server2 = new ServerSocket(7777);		// server started and waiting for connection
			System.out.println("****************	Waiting for the Connection	****************");
			Socket client2 = server2.accept();		// server accept the cliecnt request
			System.out.println("Connection established");

			DataInputStream din = new DataInputStream(client2.getInputStream());		//object for input on server
			DataOutputStream dout = new DataOutputStream(client2.getOutputStream());	//object for output data on server

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //object for taking input from user
			String msgin="";

			while (!msgin.equals("exit")) {	
				msgin=din.readUTF();
				System.out.println("[Server] : "+msgin);
			}
			client2.close();
		}catch (Exception e) {
			System.out.println("****************	session end	****************");
		}
	}
}

class ChatClient2 implements Runnable {		
	public void run() {	
		try {
			//try{Thread.sleep(5000);}catch(Exception e){}			//delay for request of client and server
			Socket client2 = new Socket("localhost",6666);		//client request to particular server
			System.out.println("Connection established");
			
			DataInputStream din = new DataInputStream(client2.getInputStream());
			DataOutputStream dout = new DataOutputStream(client2.getOutputStream());

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //object for taking input from user
			String msgout="";
		
			while (!msgout.equals("exit")) {
				msgout = br.readLine();
				dout.writeUTF(msgout);
				dout.flush();
			}
		}catch (Exception e) {
			System.out.println("Wrong port number. please try again later");
		}
	}
 } 
 
 class ChatThread2
 {
 	public static void main(String[] args) throws Exception
 	{	
 		new Thread(new ChatServer2()).start();			
 		new Thread(new ChatClient2()).start();	
 		
 		
 	}
 }
