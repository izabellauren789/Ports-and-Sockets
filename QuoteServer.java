/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
  // Your code is here
  public static void main(String[] args) {
    try 
    {
      ServerSocket sock = new ServerSocket(6017); // change this to port 17, where we pull from pre existing
      /* now listen for connections */
      while (true) 
      {
        Socket client = sock.accept();
        PrintWriter pout = new
        PrintWriter(client.getOutputStream(), true);
        /* write the Date to the socket */ //write quote of day
        /*CHANGE THIS LINE */
        pout.println(new java.util.Date().toString()); //change front part, keep toString()
        /* close the socket and resume */
        /* listening for connections */
        client.close();
      }
    }
    catch (IOException ioe) 
    {
      System.err.println(ioe);
    }
  }
}
