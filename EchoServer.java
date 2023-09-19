/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */

 import java.io.*;
 import java.net.*;
 
 public class EchoServer {
     public static void main(String[] args) {
         int port = 6007;
         try (ServerSocket serverSocket = new ServerSocket(port)) {
             System.out.println("Server listening on port " + port);
             
             while (true) {
                 try (Socket clientSocket = serverSocket.accept()) {
                     InputStream inputStream = clientSocket.getInputStream();
                     OutputStream outputStream = clientSocket.getOutputStream();
                     
                     byte[] buffer = new byte[1024];
                     int bytesRead;
                     
                     while ((bytesRead = inputStream.read(buffer)) != -1) {
                         outputStream.write(buffer, 0, bytesRead);
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
 
