/**
 * Quote server listening to port 6017.
 *
 */
 
 import java.net.*;
 import java.io.*;
 import java.util.Random;
 
 public class QuoteServer {
   public static void main(String[] args) {
     try {
       String quoteList[] = {"Learn from yesterday, live for today, hope for tomorrow", "Count your life by smiles, not tears", 
       "The only way to do great work is to love what you do", "You are never too old to set another goal or dream a new dream",
       "You have brains in your head. You have feet in your shoes. You can steer yourself any direction you choose",
       "Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on", 
       "The essential conditions of everything you do must be choice, love, passion"};
      ServerSocket sock = new ServerSocket(6017); // Listen on port 6017
       /* now listen for connections */
       while (true) {
         Socket client = sock.accept(); //, accept() returns socket
         PrintWriter pout = new PrintWriter(client.getOutputStream(),true);

         Random rand = new Random();//use random to choose random quote from quoteList
         int i = rand.nextInt(6);
         pout.println(quoteList[i]); // printwrite object can use println to write to socket to communicate with server
         // Close the sockets
         client.close(); // opened sockets must be closed
       }
      } 
      catch (IOException ioe) {
       System.err.println(ioe);
     }
    }
  }



 