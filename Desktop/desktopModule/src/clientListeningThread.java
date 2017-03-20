package src;

import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientListeningThread extends Thread {
    private ObjectInputStream input ;

    public clientListeningThread(ObjectInputStream input){
        this.input = input;


    }



    public void run(){
        while(true){
            try {
                String message=(String) input.readObject();
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
