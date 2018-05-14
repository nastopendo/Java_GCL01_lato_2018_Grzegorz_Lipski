import server.CustomServer;

import java.io.IOException;

public class SerwerProgram {
    public static void main(String[] args) throws Exception{
        int port = 8080;

        CustomServer server = new CustomServer();

        try
        {
            server.run( port );
            System.out.println( "Server started." );
        }
        catch ( IOException ex )
        {
            System.out.println( "Server starting problem. Check port availability." );
            return;
        }

        server.stop();
        System.out.println( "Server stopped." );
    }
}
