package com.company;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.Executor;

/**
 * Created by repcak on 25.02.2017.
 */
public class ClientThreads implements Runnable {


    //Streams for handling communication
    private PrintWriter writer = null;
    private BufferedReader reader = null;
    private Socket client;
    private Executor ex;

    public String USERNAME;
    public String IP;
    public Socket SOCK;


    public ClientThreads(Socket client){
        this.client = client;

    }

    @Override
    public void run() {

        try{

        //Streams for handling communication
        OutputStream out = client.getOutputStream();
        writer = new PrintWriter(out);

        InputStream in = client.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        //===================================QWE

        /*System.out.println(client.getLocalAddress().getHostAddress());
        System.out.println(client.getLocalAddress().getAddress()[0]);
        System.out.println(client.getLocalAddress().getHostName());*/



        String s = null;
        s = reader.readLine();

        if (!isClientAuthenticated(s)){
            return;
        }

        while((s = reader.readLine()) != null){




            writer.write(s + "\n");
            writer.flush();
            System.out.println("Client said: " + s);

        }





        //Streams need to be closed. They cannot be closed in the main "try" block
        //Thats why ther are in the 'finally' block so they will be always closed.
        }catch(IOException e){
            e.printStackTrace();
            return;
        }finally{
            try{
                if(writer != null) writer.close();
                if(reader != null) reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    private boolean isClientAuthenticated(String s){

        boolean isAuthenticated = true;
        String nick = nicknameCheck(s);

        if (nick.isEmpty()){
            isAuthenticated = false;
        }
        else{
            this.USERNAME = nick;
        }

        return isAuthenticated;
    }


    /**
     * UPDATE: Accepts all ASCI signs at the moment leading
     * that the nick can be gibberish like "kl;jm!@*%!@#SD___-1!@#"
     * NICK HAS TO BE WITHOUT "@"
     *
     * Login credentials based on twitch API.
     *
     * Username can be only 1 continious string. If more is added
     * the server will reject connection.
     *
     * @param message 'NICK chat_username'
     * @return Returns a string with username, if not returns an empty string which equals to false
     */
    private String nicknameCheck(String message){

        String NICKtokken = "NICK";

        boolean isLoginCorrect = true;
        String nick = "";

        //Regex spliting string by whitespaces
        String[] splitStr = message.split("\\s+");
        String firstElement = splitStr[0].trim();

        if(splitStr.length != 2){
            isLoginCorrect = false;
        }

        //Chekcs if first element of message is "NICK"
        if(!NICKtokken.equals(firstElement)){
            isLoginCorrect = false;
        }

        if (isLoginCorrect) {
            nick = splitStr[1];
        }

        return nick;
    }

}
