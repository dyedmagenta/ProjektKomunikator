package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by repcak on 25.02.2017.
 */
public class ComServer {


    //Lists for sockets and usernames
    public static ArrayList<Socket> SocketConnectionArray = new ArrayList<>();
    public static ArrayList<String> CurrentUsersNames = new ArrayList<>();


    //Starts the main server
    public ComServer startServer(){


        //Creates a server socket on the given port
        ServerSocket server = null;
        try {
            server = new ServerSocket(6666);
            System.out.println("Server started! ");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //AVOID PUTTING CODE HERE. THIS IS ONLY FOR ACCEPTING NEW CLIENTS
        //Awaits new connections from clients. If someone connects a new Thread is
        //started based on ClientThreads class where the run() method is. A
        while(true){
            try{
                Socket client = server.accept();

                //TEST Adds socket
                SocketConnectionArray.add(client);
                System.out.println(SocketConnectionArray.size());


                ClientThreads CHAT = new ClientThreads(client);
                Thread X = new Thread(CHAT);
                X.start();
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

