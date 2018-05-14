package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomServer {

    private static final int PING_FRAME = 1;
    private static final int HELLO_WORLD_FRAME = 2;

    ServerSocket serverSocket;

    public void run( int port ) throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = bufferedReader.readLine();
        System.out.println(message);

        if(message != null){
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Message received");
        }
        bufferedReader.close();
        inputStreamReader.close();
        socket.close();
        serverSocket.close();
    }
    public void stop(){

    }
    private void doClientLogic( Socket socket ) throws IOException{
        //TODO: poprawne zamykanie strumieni
        DataInputStream input = new DataInputStream( socket.getInputStream() );
        DataOutputStream output = new DataOutputStream( socket.getOutputStream() );
        while( !Thread.interrupted() )
        {
            switch( input.readInt() )
            {
                case PING_FRAME:
                    output.writeInt( PING_FRAME ); // odsyłamy typ ramki (pusta ramka)
                    output.flush();
                    break;
                case HELLO_WORLD_FRAME:
                    output.writeInt( HELLO_WORLD_FRAME ); // typ ramki
                    output.writeUTF( "HELLO WORLD!" ); // dane ramki
                    output.flush();
                    break;
                //next cases…
            }
        }
    }
}
