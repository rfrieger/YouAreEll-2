package controllers;

import java.util.ArrayList;

import com.sun.jndi.toolkit.url.UrlUtil;
import com.sun.org.apache.xpath.internal.operations.String;
import models.Id;

public class IdController {
    private String url;
    private ArrayList<Id> idArrayList;

    public IdController() {
    }

    public void getIDRespones(String url){

    }

    public IdController(ArrayList<Id> set) {
        this.idArrayList = set;
    }

    public ArrayList<Id> getIdArrayList() {
        return idArrayList;
    }

    public void setIdArrayList(ArrayList<Id> idArrayList) {
        this.idArrayList = idArrayList;
    }

    public void print () {
        for (Id id : idArrayList) {
            System.out.println(id.toString());
        }


    }
}