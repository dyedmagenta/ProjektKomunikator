package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientListeningThread extends Thread {
    private BufferedReader input ;
    private boolean running = true;

    // this is basic constructor that has one parameter, which contains Client's ObjectInputStream
    public clientListeningThread(BufferedReader input){
        this.input = input;


    }

    // method used to terminate thread
    public void terminate(){
        this.running=false;
    }

    // run method that listens for incomming messages from server.
    //after receiving one, this methods sends message to clienthandler Class
    public void run(){
        while(running){
            try {
                String message=(String) input.readLine();
                System.out.println("MSG received: "+ message);
                clientHandler.receiveMessage(message);


            } catch (IOException e) {

            }


        }



    }


}
