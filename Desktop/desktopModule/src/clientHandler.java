package src;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientHandler {

    private static Client client;
    private static clientGui Gui;
    private static boolean connectedToServer = false;
    public static void main(String[] args) {
        Gui = new clientGui();
        Gui.setVisible(true);

    }
    public static void createNewClient(String userName,String serverAddress,String serverPort){
        if(!connectedToServer) {
            try {
                client = new Client(userName, InetAddress.getByName(serverAddress), Integer.parseInt(serverPort));
                connectedToServer=true;
            } catch (UnknownHostException e) {

            }
        }else{
            client.disconnect();
            connectedToServer=false;
            createNewClient(userName, serverAddress, serverPort);


        }

    }




    public static void sendMessage(String message){
        client.sendMessage(message);
    }

    public static void receiveMessage(String message){
        System.out.println("clientHandler: message = "+ message);
        Gui.appendMessage(message);
    }

    }

