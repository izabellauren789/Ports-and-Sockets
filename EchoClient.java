/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) 
    {
        try (Socket socket = new Socket("127.0.0.1", 6007)) 
        {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Send data to the server
            String message = "Hello, World.";
            out.write(message.getBytes());

            // Receive and print the response from the server
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            if (bytesRead != -1) {
                String response = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

