package src.testSRV;


        import java.io.*;
        import java.net.*;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;
/**
 * Created by gwozdo on 19.03.2017.
 */
public class Server {

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ServerSocket server;
    private Socket connection;

    public void startRunning(){
        try{

            server = new ServerSocket(1234,100);
            while(true){
                try{
                    waitForConnection();
                    setupStreams();
                    whileChatting();

                }catch(EOFException e){
                    System.out.println("user disconnected");
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }



    }


    private void whileChatting() throws IOException {
        String message = "you connectedf to server";
        sendMessage(message);
        while(true){
            try {
                message = (String) input.readObject();
                System.out.println(message);
                sendMessage( message);
            }catch (ClassNotFoundException e){
                System.out.println("unknown command");
            }
        }
    }

    private void sendMessage(String message) {
        try{
            output.writeObject("SERVER: "+message);
            output.flush();
            System.out.println("replied to user: " + message);
        }catch(IOException e){
            System.out.println("error sending shiet");
        }

    }

    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input=new ObjectInputStream(connection.getInputStream());
        System.out.println("ustawiłem streamy");
    }

    private void waitForConnection() throws IOException{
        System.out.println("czekam na connecta ...");
        connection = server.accept();
        System.out.println("connected !");
    }
}
