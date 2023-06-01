import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket c = new Socket("10.0.37.16", 3000 );
    }
}
