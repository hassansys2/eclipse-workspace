import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioFormat.Encoding;
import javax.swing.*;
import java.awt.print.*;
 
public class HelloWorldPrinterClass implements Printable, ActionListener {
 
 
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        g.drawString("Hello world!", 100, 100);
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
 
    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         //boolean ok = job.printDialog();
         if (true) {
             try {
                  job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }
 
    public static void main(String args[]) {
  
        /*
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Hello World Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Hello World");
        printButton.addActionListener(new HelloWorldPrinterClass());
        f.add("Center", printButton);
        //f.pack();
        f.setVisible(true);
        */
    	
    	
    	/*
    	Socket clientSock = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
    	clientSock.NoDelay = true;
    	IPAddress ip = IPAddress.Parse("192.168.0.18");
    	IPEndPoint remoteEP = new IPEndPoint(ip, 9100);
    	clientSock.Connect(remoteEP);
    	Encoding enc = Encoding.ASCII;

    	// Line feed hexadecimal values
    	byte[] bEsc = new byte[4];
    	bEsc[0] = 0x0A;
    	bEsc[1] = 0x0A;
    	bEsc[2] = 0x0A;
    	bEsc[3] = 0x0A;

    	// Send the bytes over 
    	clientSock.Send(bEsc);

    	// Sends an ESC/POS command to the printer to cut the paper
    	String output = Convert.ToChar(29) + "V" + Convert.ToChar(65) + Convert.ToChar(0);
    	char[] array = output.ToCharArray();
    	byte[] byData = enc.GetBytes(array);
    	clientSock.Send(byData);
    	clientSock.Close();
    	*/
    }
}