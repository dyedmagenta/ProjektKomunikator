package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Repcak on 25.02.2017.
 */
public class ComServer {


    //Lists for sockets and usernames
    public static ArrayList<Socket> ConnectionArray = new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();


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

        //Executors - Framework for threads. Creates a ThreadPool
        //to which we can add threads
        ExecutorService executor = Executors.newCachedThreadPool();


        //AVOID PUTTING CODE HERE. THIS IS ONLY FOR ACCEPTING NEW CLIENTS
        //Awaits new connections from clients. If someone connects a new Thread is
        //started based on ClientThreads class where the run() method is. A
        while(true){
            try{
                Socket client = server.accept();

                executor.execute(new ClientThreads(client));
                
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

