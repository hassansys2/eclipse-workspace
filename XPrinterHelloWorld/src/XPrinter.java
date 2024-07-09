import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class XPrinter {
	public static void main(String [] args) throws UnknownHostException, IOException {
		String host = "192.168.0.100";

		Socket socket = new Socket(host, 9100);
		OutputStream socketOutputStream = socket.getOutputStream();
		InputStream socketInputStream = socket.getInputStream();
		char tab = '\t';
		char newline = '\n';
		
		String str = "\t\tThe Chaaye Spot" + newline + newline + 
				"No." + tab + "Item Name" + tab + tab + "Qty" + tab + "Total" + newline +
				"1." + tab + "Karrak Chaaye" + tab + tab + "2.00" + tab + "150" + newline +
				"2." + tab + "Masala Chaaye" + tab + tab + "1.00" + tab + "75" + newline +
				"3." + tab + "Chicken Sandwich" + tab + tab + "3.00" + tab + "475" + newline + newline +
				"TOTAL" + tab + tab + "956" + newline +
				"Tendered" + tab + tab + "1000" + newline +
				"Change" + tab + tab + "44" + newline + newline +
				
				"Thanks for visiting us ... We welcome you agian." + newline;
				
		//socketOutputStream.write(str.getBytes("iso-8859-1"));	// Also Works Fine
		socketOutputStream.write(str.getBytes());
		socketOutputStream.write(new byte[]{0x1d, 0x56, 0x42, 0x00, 0x0a});		// Paper Cut Command
		System.out.print(str);
		
		/*System.out.print("Data From Printer !\n");
		System.out.print("Number of Bytes Received : " + socketInputStream.read());
		int x = 0;
		while(x != -1){
			x = socketInputStream.read();
			System.out.print(x);
		}*/ 
			
		socketInputStream.close();
		socketOutputStream.flush();
		socketOutputStream.close();
		socket.close();
	}

}
