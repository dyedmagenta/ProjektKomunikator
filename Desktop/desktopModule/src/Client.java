package src;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by gwozdo on 19.03.2017.
 */

public class Client extends Thread{
    private String message ;
    private String serverIP;
    private Socket connection;


    private  ObjectOutputStream output;
    private ObjectInputStream input ;





    private void connectToServer() throws IOException{
        connection = new Socket(InetAddress.getLocalHost(),1234);
        System.out.println("Client connected to Server");

    }


    public Client(){
        startRunning();



    }

    private void setupStreams(){
        try {
            output= new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            System.out.println( "Clients streams set up! ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void closeEverything(){
        System.out.println ("Closing everything");
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
    public void startRunning(){

        try {
            connectToServer();
            setupStreams();
            clientListeningThread thrd = new clientListeningThread(input);
            thrd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void sendMessage(String message){
        try {
            output.writeObject("Client: "+ message);
            output.flush();
            System.out.println("MSG: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void whileChatting(){
        while(true){
            try {
                message=(String) input.readObject();
                System.out.println("MSG received: "+ message);
                clientHandler.receiveMessage(message);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }


    }





}
