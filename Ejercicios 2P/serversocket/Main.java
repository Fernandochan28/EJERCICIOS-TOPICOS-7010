import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        Socket c;
        ServerSocket server = new ServerSocket(3000);
        c = server.accept();
    }
}