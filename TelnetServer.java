import java.io.*;
import java.net.*;

public class TelnetServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Telnet Server started on port 8080...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("Welcome to Telnet Server! Type 'exit' to quit.");
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                out.println("Echo: " + message);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
