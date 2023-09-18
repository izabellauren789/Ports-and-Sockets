/**
 * Quote server listening to port 6017.
 *
 */
 
 import java.net.*;
 import java.io.*;
 
 public class QuoteServer {
   public static void main(String[] args) {
     try {
       ServerSocket sock = new ServerSocket(6017); // Listen on port 6017
       /* now listen for connections */
       while (true) {
         Socket client = sock.accept();
         PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
 
         // Create a Socket to connect to the target server on port 17 (Quote of the day)
         Socket targetServer = new Socket("127.0.0.1", 17); // You can replace "localhost" with the actual server's IP
         
         // Get input and output streams for communication with the target server
         InputStream targetIn = targetServer.getInputStream();
         BufferedReader targetReader = new BufferedReader(new InputStreamReader(targetIn));
 
         // Read the quote of the day from the target server
         String quoteLine;
         while ((quoteLine = targetReader.readLine()) != null) {
           pout.println(quoteLine);
         }
 
         // Close the sockets
         client.close();
         targetServer.close();
       }
      } 
      catch (IOException ioe) {
       System.err.println(ioe);
     }
    }
  }



 