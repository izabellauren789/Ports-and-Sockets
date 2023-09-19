/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) 
    {
        String serverHost = "127.0.0.1";
        int serverPort = 6007;

        try (Socket socket = new Socket(serverHost, serverPort)) 
        {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            // Send data to the server
            String message = "Hello, world";
            outputStream.write(message.getBytes());

            // Receive and print the response from the server
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            if (bytesRead != -1) {
                String response = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

