This is full duplex peer-to-peer command line chat application based on Tcp protocol connection

ChatThread1.java - (is for the first machine just paste in your any directory) 

ChatThread2.java - (is for the second machine)

---------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------
 ******************* implementation work *************************
 
 Step 1: how to use?
 		Its is java code so you need jdk to compile and run
 		Based on socket programming
 		
 There are seperate thread for sending and recieving on both side
 source and desitnation.
 Server thread is for receiving message
 Client Thread is for sending message
 
 Step 2 : How to configure ?
 			In ChatClient class you have to fixed Ip and port for connection
 e.g
 Suppose Machine1 have ip : 10.42.19.12 and port 6666
 and Machine2 have ip : 10.42.19.112 and port 7777
 
 here machine1 server gonna use 6666 port and ip and port for client thread will be of machine2 (ip: 10.42.19.112 and 7777)
 same for the machine2 , server will use 6666 and client thread use ip and port of machine1
 
 
 ********* easy to use *****************
