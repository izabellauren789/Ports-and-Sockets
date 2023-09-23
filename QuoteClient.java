/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
	public static void main(String[] args) {
		try 
		{
			/* make connection to server socket */
			Socket sock = new Socket("127.0.0.1",6017);
			InputStream in = sock.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in)); //read in text from server
			/* read the date from the socket */
			String line;
			while ( (line = bin.readLine()) != null) // bufferedreader class can read data line by line using readLine
			System.out.println(line);
			/* close the socket connection*/
		sock.close(); // opened sockets must be closed
		}
		catch (IOException ioe) 
		{
			System.err.println(ioe);
		}
	}
}
