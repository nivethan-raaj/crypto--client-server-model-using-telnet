import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TelnetClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Connected to Telnet Server");
            System.out.println(in.readLine());
            
            String userInput;
            while (!(userInput = scanner.nextLine()).equalsIgnoreCase("exit")) {
                out.println(userInput);
                System.out.println("Server: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
