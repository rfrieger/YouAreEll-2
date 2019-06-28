package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import models.Id;
import models.Message;

public class MessageController {
    private ArrayList response = new ArrayList();
    private LinkedHashSet<Message> messagesSeen;


    public MessageController(LinkedHashSet hashSet) {
        messagesSeen = hashSet;
    }


    // why a HashSet??

    public MessageController() {

    }


    public LinkedHashSet<Message> getMessages() {
        return messagesSeen;
    }

    public void setMessageSeen(LinkedHashSet<Message> messages) {
        messagesSeen = messages;
    }


    public void printMessages() {
        messagesSeen.stream().limit(5).forEach(p-> System.out.println(p.toString()));
    }

}