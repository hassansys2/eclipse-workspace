import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class mod_bus extends Thread {
	
	private ServerSocket serverSocket;
	   
	   public mod_bus(int port) throws IOException {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(100000);
	   }

	   public void run() {
	      while(true) {
	         try {
	        	int len = 0;
	        	byte[] str = new byte[50];
	        	
	            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
            	System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            
            	
            	DataInputStream in = new DataInputStream(server.getInputStream());
            	len = in.available();
	            if( len > 0 ) {
	            	//while(in.available() > 0)	System.out.println(in.read());
	            	int readlen = in.read(str,0,len);
	            	System.out.println("Data Available On Socket : " + len + ", Readlen : " + readlen);
	            	System.out.println(new String(str));
	            }
	            
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.write("HELLO_THIS IS SERVER".getBytes());
	            //out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()  + "\nGoodbye");
	            
	            server.close();
	            
	         } catch (SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break; 
	         } catch (IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello This is Server");
		int port = Integer.parseInt("503");
	      try
	      {
	    	  Thread t = new mod_bus(port);
	    	  t.start();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }

	}

}
