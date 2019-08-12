import java.io.*;
import java.net.*;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.packager.GenericPackager;

public class Pose 
{
	public static void main(String argv[]) throws Exception
	{
	     String fromclient;
	     String toclient;
	      
	     ServerSocket Server = new ServerSocket (5454);
	     
	     System.out.println ("TCPServer Waiting for client on port 5454");
	
	     while(true) 
	     {
	     	Socket connected = Server.accept();
	        
	        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));    
	 
	        BufferedReader inFromClient = new BufferedReader(new InputStreamReader (connected.getInputStream()));
	              
	        PrintWriter outToClient = new PrintWriter(connected.getOutputStream(),true);
	        
			while (true)
			{
				fromclient = inFromClient.readLine();
		    	System.out.println( "RECIEVED:" + fromclient );
		    	// Create Packager based on XML that contain DE type
				GenericPackager packager = new GenericPackager("basic.xml");
		    	// Create ISO Message
				ISOMsg isoMsg = new ISOMsg();
				isoMsg.setPackager(packager);
				isoMsg.unpack(fromclient.getBytes());
		    //	ParseISOMessage.logISOMsg(isoMsg);
			} 
     	}
	}
}