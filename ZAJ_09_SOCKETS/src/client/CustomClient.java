package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class CustomClient {

    private boolean connected = false;
    private boolean looped = false;

    private Socket clientSocket;
    private Thread clientThread;

    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public boolean isConnected()
    {
        return this.connected;
    }

    public boolean isLooped()
    {
        return this.looped;
    }

//    Socket socket;

    protected void performClient( Socket clientSocket ){
        try
        {
            //this.outputStream = Utils.createOutputStream( clientSocket );
            OutputStream outputStream = clientSocket.getOutputStream();

            try
            {
                this.outputStream = new ObjectOutputStream( outputStream );
            }
            catch ( IOException ex )
            {
                outputStream.close();

                throw ex;
            }
            //this.inputStream = Utils.createInputStream( clientSocket );
            InputStream inputStream = clientSocket.getInputStream();
            BufferedInputStream buffer = null;

            try
            {
                buffer = new BufferedInputStream( inputStream );

                this.inputStream = new ObjectInputStream( buffer );
            }
            catch ( IOException ex )
            {
                if ( buffer != null ){
                    try
                    {
                        buffer.close();
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                }
                    //Utils.close( buffer );

                inputStream.close();

                throw ex;
            }
        }
        catch ( IOException ex )
        {
            if ( this.outputStream != null )
                try
                {
                    this.outputStream.close();
                }
                catch ( IOException e )
                {
                    e.printStackTrace();
                }
                //Utils.close( this.outputStream );
        }
    }

    public void connect(InetAddress host, int port ) throws IOException {

        if ( this.connected )
            throw new IOException( "Client is already connected." );;

        this.clientSocket = new Socket( host, port );
        this.clientThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    CustomClient.this.performClient( CustomClient.this.clientSocket );
                }
                finally
                {
                    try
                    {
                        CustomClient.this.clientSocket.close();
                    }
                    catch ( IOException e )
                    {
                        e.printStackTrace();
                    }
                    //Utils.close( CustomClient.this.clientSocket );
                    CustomClient.this.connected = false;
                }
            }
        };

        this.looped = true;

        this.clientThread.start();
        this.connected = true;

//        socket = new Socket(host, port);
//
//        PrintStream printStream = new PrintStream(socket.getOutputStream());
//        printStream.println("Hello to server from client");
//
//        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//        String message = bufferedReader.readLine();
//        System.out.println(message);
//
//        bufferedReader.close();
//        inputStreamReader.close();
//        socket.close();
    }
    public void disconnect(){
        if ( this.connected )
        {
            this.looped = false;

            try
            {
                this.clientSocket.close();
            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }

            try
            {
                this.clientThread.join();
            }
            catch ( InterruptedException e )
            {
                e.printStackTrace();
            }

           // Utils.close( this.clientSocket );
           // Utils.join( this.clientThread );
        }
    }
    public void logout() throws IOException{

    }
    public boolean ping() throws IOException{
        return true;
    }
    public boolean echo( String text ) throws IOException{
        return true;
    }
}
