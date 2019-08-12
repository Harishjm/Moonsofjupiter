import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ATM_Client {
static String msg="";
	static ObjectInputStream in=null;
  static	ObjectOutputStream out=null;
	
	public static void main(String[] args) throws ClassNotFoundException {
		 try {
			Socket clientsocket=new Socket("localhost", 2019);
			//Created clientSocket to connect to the server
			System.out.println("Connected to localhost in Port 2019");
		out =new ObjectOutputStream(clientsocket.getOutputStream())	;
		out.flush();
		in=new ObjectInputStream(clientsocket.getInputStream());
		msg=(String)in.readObject();
		System.out.println("Recived Message is->"+msg);
		SendMessage("$ CLIENT--> Hey Server");
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 static void SendMessage(String Msg){
		 try {
			out.writeObject(Msg);
			out.flush();
			System.out.println("Msg has been Sent");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
}
