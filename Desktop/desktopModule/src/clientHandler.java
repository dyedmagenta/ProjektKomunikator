package src;

/**
 * Created by gwozdo on 20.03.2017.
 */
public class clientHandler {
    private static Client client;
    private static clientGui Gui;
    public static void main(String[] args) {
        Gui = new clientGui();
        Gui.setVisible(true);
    }
    public static void createNewClient(){
         client = new Client();


    }
    public static void sendMessage(String message){
        client.sendMessage(message);
    }

    public static void receiveMessage(String message){
        System.out.println("clientHandler: message = "+ message);
        Gui.appendMessage(message);
    }

    }

