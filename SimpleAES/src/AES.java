import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class AES {
    
    public static void main(String[] args)
    {
        //Check Respective Java Classess for AES Crypto
    	
    	try
    	{
    		InetAddress ip = InetAddress.getByName("esp8266.local");
    		//ip = Inet4Address.getByName("Hassan-ZPC.local");
    		String msg = "Hello World";
    		
    		
	    	System.out.println("Host Name: "+ip.getHostName());  
	    	System.out.println("IP Address: "+ip.getHostAddress());
	    	Socket myESP = new Socket(ip,8888);
	    	if(myESP.isConnected())
	    	{
	    		OutputStream myESPOut = myESP.getOutputStream();
	    		myESPOut.write(msg.getBytes());
	    		myESPOut.close();
	    		myESP.close();
	    	}
	    }
    	catch(IOException e)
    	{
    		System.out.println(e);
    	}
    	
    	
    	
    	
    	
    	
    	// Searching for All Host on Network
    	/*
    	try {
		    	InetAddress localhost = InetAddress.getLocalHost();
		    	// this code assumes IPv4 is used
		    	byte[] ip = localhost.getAddress();
		    	for (int i = 1; i <= 254; i++)
		    	{
		    		//System.out.print(i);
		    	    ip[3] = (byte)i;
		    	    InetAddress address = InetAddress.getByAddress(ip);
		    	    if (address.isReachable(1))
		    	    {
		    	        // machine is turned on and can be pinged
		    	    	System.out.println("\nHost Found : " + address.getHostName());
		    	    }
		    	    else if (!address.getHostAddress().equals(address.getHostName()))
		    	    {
		    	        // machine is known in a DNS lookup
		    	    	System.out.println("Second Option i = " + i);
		    	    }
		    	    else
		    	    {
		    	        // the host address and host name are equal, meaning the host name could not be resolved
		    	    	// machine is known in a DNS lookup
		    	    	System.out.println("Second Option i = " + i);
		    	    }
		    	}
    	}catch(UnknownHostException e) {
    		
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}