package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.Id;
import models.Message;

public class MessageController {

    private HashSet<Message> messagesSeen;

    public HashSet<Message> getMessagesSeen() {
        return messagesSeen;
    }

    public void setMessagesSeen(HashSet<Message> messagesSeen) {
        this.messagesSeen = messagesSeen;
    }

    public void print() {
        for (Message message : messagesSeen) {
            System.out.println(message.toString());
        }

    }
}
