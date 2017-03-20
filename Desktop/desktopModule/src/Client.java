package src;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by gwozdo on 19.03.2017.
 */

public class Client extends Thread{
    private String userName = "anonim";
    private String message ;
    private Socket connection;
    private clientListeningThread thrd;

    private  ObjectOutputStream output;
    private ObjectInputStream input ;





    private void connectToServer(String userName,InetAddress adres, int port) throws IOException{
        connection = new Socket(adres,port);
        System.out.println(userName + "connected to Server");

    }


    public Client(String userName,InetAddress adres, int port){
        this.userName=userName;
        startRunning(adres,port);



    }


    public void startRunning(InetAddress adres, int port){

        try {
            connectToServer(userName,adres,port);
            setupStreams();
            thrd = new clientListeningThread(input);
            thrd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void setupStreams(){
        try {
            output= new ObjectOutputStream(connection.getOutputStream());
            output.writeObject("userName: "+ this.userName);
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            System.out.println( "Clients streams set up! ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void disconnect(){
        System.out.println ("Closing everything");
        try {
            thrd.terminate();
            output.close();
            input.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String message){
        try {
            output.writeObject(userName + " : "+ message);
            output.flush();
           // System.out.println("MSG: " + message);
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
