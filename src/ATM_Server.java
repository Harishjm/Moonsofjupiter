import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ATM_Server {
static ObjectOutputStream objectoutputstream=null;
static ObjectInputStream objectinputstream=null;
	public static void main(String[] args) throws ClassNotFoundException {
	try {
		ServerSocket serversocket=new ServerSocket(2019,10);//Created Server
		System.out.println("Waiting for Connection");
		Socket serverconnection=serversocket.accept();
		System.out.println("Connection Recived from-->"+serverconnection.getInetAddress().getLocalHost());
		//It will recive the connection from 127 port
		
		 objectoutputstream=new ObjectOutputStream(serverconnection.getOutputStream());
		//this is for writing primitive datatypes
		objectoutputstream.flush();
		//Flush it out
		
		 objectinputstream=new ObjectInputStream(serverconnection.getInputStream());		
	     SendMessage("$SERVER : This is First Message from Server");
		  String msg=(String) objectinputstream.readObject(); 
		System.out.println(msg);
		
	} catch (IOException e) {
		System.out.println(e);
		e.printStackTrace();
	}
	
	
	
	}

	
	 static void SendMessage(String Msg){
		 try {
			objectoutputstream.writeObject(Msg);
			objectoutputstream.flush();
			System.out.println("Msg has been Sent");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }

}
