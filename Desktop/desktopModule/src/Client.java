package src;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by gwozdo on 19.03.2017.
 */

public class Client extends Thread{

    // creating variables
    private String userName = "anonim";
    private String message ;
    private Socket connection;
    private clientListeningThread thrd;
    private  ObjectOutputStream output;
    private ObjectInputStream input ;



    // Client class constructor, which sets username and runs startRunning() method.
    public Client(String userName,InetAddress adres, int port){
        this.userName=userName;
        startRunning(adres,port);

    }

    // method that establishes Socket connection to given Server
    private void connectToServer(InetAddress adres, int port) throws IOException{
        connection = new Socket(adres,port);
//tst//System.out.println(userName + "connected to Server");

    }




    // method that launches client connection and stream seting methods. Also starts clientListeningThread
    public void startRunning(InetAddress adres, int port){

        try {
            connectToServer(adres,port);
            setupStreams();
            thrd = new clientListeningThread(input);
            thrd.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // this method sets up input and output streams. Also it sends first message to server.
    private void setupStreams(){
        try {
            output= new ObjectOutputStream(connection.getOutputStream());
            output.writeObject("userName: "+ this.userName);
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
//tst// System.out.println( "Clients streams set up! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //this method disconnects current user from server by sending EOC message, terminating Client thread
    //closing Streams and finally closing Socket connection
    public void disconnect(){
        System.out.println ("Closing everything");
        try {


            thrd.terminate();
            output.close();
            input.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }catch(NullPointerException f){
            System.out.println("erorororo");
        }

    }


    //this method is used to compose and send message to server
    public void sendMessage(String message){
        try {
            output.writeObject(userName + " : "+ message);
            output.flush();
//tst// System.out.println("MSG: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
