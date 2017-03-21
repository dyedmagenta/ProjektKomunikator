package src;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientHandler {
// this class handlec creating Client connections, disconnects and sending messages between Gui and Client objects
    private static Client client;
    private static clientGui Gui;
    private static boolean connectedToServer = false;
    public static void main(String[] args) {
        Gui = new clientGui();
        Gui.setVisible(true);

    }

    //method used
    public static void createNewClient(String userName,String serverAddress,String serverPort){
        if(!connectedToServer) {
            try {
                client = new Client(userName, InetAddress.getByName(serverAddress), Integer.parseInt(serverPort));
                connectedToServer=true;
            } catch (UnknownHostException e) {

            }
        }else{
            disconnectClient();

            createNewClient(userName, serverAddress, serverPort);


        }

    }



    //method forrwarding message from Gui to client's object
    public static void sendMessage(String message){
        client.sendMessage(message);
    }

    //method forrwarding message from client's object to Gui
    public static void receiveMessage(String message){
        System.out.println("clientHandler: message = "+ message);
        Gui.appendMessage(message);
    }
    public static void disconnectClient(){
        System.out.println("DC method running");
        connectedToServer=false;
        client.disconnect();


    }
    }

