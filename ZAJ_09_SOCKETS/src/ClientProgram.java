import client.CustomClient;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

public class ClientProgram {
    public static void main(String[] args) throws Exception{

        CustomClient client = new CustomClient();

        InetAddress address = Inet4Address.getByName( "192.169.0.103" );
        int port = 8080;

        try
        {
            client.connect( address, port );
            System.out.println( "Client connected." );
        }
        catch ( IOException ex )
        {
            System.out.println( "Client connection problem. Check address, port or server status." );
            return;
        }

        client.disconnect();
        System.out.println( "Client disconnected." );
    }
}
