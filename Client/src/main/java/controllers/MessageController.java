package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import models.Id;
import models.Message;

public class MessageController {




    private HashSet<Message> messagesSeen;
    // why a HashSet??


    public HashSet<Message> getMessagesSeen() {
        return messagesSeen;
    }

    public void setMessagesSeen(HashSet<Message> messagesSeen) {
        this.messagesSeen = messagesSeen;
    }


}





//    public ArrayList<Message> getMessagesForId(Id Id) {
//        return null;
//    }
//    public Message getMessageForSequence(String seq) {
//        return null;
//    }
//    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
//        return null;
//    }
//
//    public Message postMessage(Id myId, Id toId, Message msg) {
//        return null;
//    }