/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
  public static void main(String[] args) {
    try 
    {
      ServerSocket sock = new ServerSocket(17); //pulling from pre existing port
      /* now listen for connections */
      while (true) 
      {
        Socket client = sock.accept();
        PrintWriter pout = new
        PrintWriter(client.getOutputStream(), true);
        /* write the Date to the socket */ //change to quote of the day
        /*CHANGE THIS LINE */
        pout.println(new java.util.Date().toString()); // change front part, keep toString()
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
