package com.company;



/**
 * Created by Repcak on 19.03.2017.
 *
 *
 *
 *  !Command
 *
 *      !NAMES
 *      Sends a list of nicks
 *
 *      !MSG
 *      Sends a message to the global server
 *      Example:
 *      !MSG@Hello everyone
 *
 *
 *
 *  Skonczylem na:
 *  Problem z API a dokladnie dzieleniem stringow bo np jak przyjdzie komenda !Names nadal bedzie szukac
 *  znaku @, trzeba znalezc uniwersalne rozwiazanie, osobna implementacja auth potrzebna, ktora nie bedzie
 *  sie wliczac w MessageStrategy
 *
 */

public class Message {



    private String sender;
    private String reciever;

    private String type;
    private String message;


    public Message(String msg, String sender){

        this.sender = sender;

        if (msg.startsWith("!")){

            //Type of message
            this.type = msg.substring(msg.indexOf("!")+1, msg.lastIndexOf("@"));

            //Gets message if any
            String[] temp = msg.split("@", 2);
            this.message = temp[1];


        }else{
            type = "ERROR";
            return;
        }




    }









    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}
