/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */

 import java.io.*;
 import java.net.*;
 
 public class EchoServer {
     public static void main(String[] args) {
         try (ServerSocket serverSocket = new ServerSocket(6007)) {
             System.out.println("Server listening on port " + 6007);
             
             while (true) {
                 try (Socket clientSocket = serverSocket.accept()) {
                     InputStream in = clientSocket.getInputStream();
                     OutputStream out = clientSocket.getOutputStream();
                     
                     byte[] buffer = new byte[1024];
                     int bytesRead;
                     
                     while ((bytesRead = in.read(buffer)) != -1) {
                         out.write(buffer, 0, bytesRead);
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 }
 
