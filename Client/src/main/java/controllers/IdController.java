package controllers;

import java.util.ArrayList;

import models.Id;

public class IdController {
    private ArrayList<Id> idArrayList;

    public IdController() { }

    public IdController(ArrayList<Id> set) {
        this.idArrayList = set;
    }

    public ArrayList<Id> getIdArrayList() {
        return idArrayList;
    }

    public void setIdArrayList(ArrayList<Id> idArrayList) {
        this.idArrayList = idArrayList;
    }

//    public Id postId(Id id) {
//        return null;
//    }
//
//    public Id putId(Id id) {
//        return null;
//    }

 
}