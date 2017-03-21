package com.company;

import java.io.*;
import java.net.Socket;

/**
 * Created by repcak on 25.02.2017.
 */
public class ClientThread implements Runnable {


    public volatile Boolean isThreadRunning = true;

    //Streams for handling communication
    private PrintWriter OUTPUT = null;
    private BufferedReader INPUT = null;

    private final Socket SOCK;


    private Boolean isAuthenticated=false;
    private String USERNAME =null;
    public String IP;


    public ClientThread(Socket client){
        this.SOCK = client;
    }

    @Override
    public void run() {

        try{

            //Streams for handling communication
            OutputStream out = SOCK.getOutputStream();
            OUTPUT = new PrintWriter(out);

            InputStream in = SOCK.getInputStream();
            INPUT = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            //===================================


            String message;

            while((message = INPUT.readLine()) != null && isThreadRunning){
                System.out.println("read " + message);



                //Authentication part
                if(message.startsWith("LOGIN") && !isAuthenticated){
                    String table[] = message.split(" ");
                    USERNAME = table[1];
                    isAuthenticated=true;
                    System.out.println("USER AUTH and ADDED TO LIST");
                    ComServer.connectionArray.add(ClientThread.this);

                }else if(!isAuthenticated){
                    isThreadRunning = false;
                    System.out.println("USER NOT AUTH");
                }




                //Echo message to every user connected and authenticated (on connectionArray)
                for(ClientThread client:ComServer.connectionArray){
                    client.OUTPUT.println(message);
                    client.OUTPUT.flush();
                    System.out.println("SENDING" + message.toLowerCase() + "TO :" + client.USERNAME);
                }



                //Checks if thread should be killed
                if(!isAuthenticated){
                    isThreadRunning = false;
                    break;
                }
            }

        //Streams need to be closed. They cannot be closed in the main "try" block
        //Thats why ther are in the 'finally' block so they will be always closed.
        }catch(IOException e){
            e.printStackTrace();
            return;
        }finally{
            try{
                if(OUTPUT != null) OUTPUT.close();
                if(INPUT != null) INPUT.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        System.out.println(USERNAME + "Ending thread");

    }
}
