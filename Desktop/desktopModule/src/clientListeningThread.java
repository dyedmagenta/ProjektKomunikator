package src;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientListeningThread extends Thread {
    private ObjectInputStream input ;
    private boolean running = true;
    public clientListeningThread(ObjectInputStream input){
        this.input = input;


    }


    public void terminate(){
        this.running=false;
    }
    public void run(){
        while(running){
            try {
                String message=(String) input.readObject();
                System.out.println("MSG received: "+ message);
                clientHandler.receiveMessage(message);


            } catch (IOException e) {

            } catch (ClassNotFoundException e) {

            }


        }



    }


}
