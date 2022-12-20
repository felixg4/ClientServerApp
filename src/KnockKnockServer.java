import java.net.*;
import java.io.*;

public class KnockKnockServer {
    public static void main(String args[]) throws IOException {
        int portNum = Integer.parseInt(args[0]);
        try (
                ServerSocket s = new ServerSocket(portNum);
                Socket c = serverSocket.accept();
                PrintWriter out = new PrintWriter(c.getOutputStream(), true);
                BufferReader in = new BufferReader(new InputStreamReader(c.getInputStream()));
        ) {
            String inputLine, outputLine;
            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);
            while ((inputLine = in.readLine()) != null) {
                out.println(outputLine = kkp.processInput(inputLine));
                if (outputLine.equals("Bye.")) break;
            }
        }
    }
}