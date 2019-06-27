package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import models.Id;
import models.Message;

public class IdController {
    private ArrayList<Id> myId;

    public IdController() { }

    public IdController(ArrayList<Id> set) {
        this.myId = set;
    }

    public ArrayList<Id> getMyId() {
        return myId;
    }

    public void setMyId(ArrayList<Id> myId) {
        this.myId = myId;
    }

//    public Id postId(Id id) {
//        return null;
//    }
//
//    public Id putId(Id id) {
//        return null;
//    }

 
}