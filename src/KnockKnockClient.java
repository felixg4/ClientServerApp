import java.net.*;
import java.io.*;

public class KnockKnockClient {
    public static void main(String[] args) throws IOException {
        String hostName = args[0];
        int portNum = Integer.parseInt(args[1]);
        try (
                Socket kkSocket = new Socket(hostName, portNum);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;
            while ((fromServer = in.readLine()) != null) {
                if (fromServer.equals("Bye")) break;
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        }
    }
}