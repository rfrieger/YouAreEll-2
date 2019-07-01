package controllers;

import models.Id;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IdControllerTest {
    ArrayList<Id> arr = new ArrayList<>();

    IdController idController = new IdController();

    @Before
    public void before(){

        arr.add(new Id("bob", "bobid", "1"));
        arr.add(new Id("job", "jobid", "12"));
        arr.add(new Id("guy", "guyid", "123"));

        idController.setiDList(arr);
    }

    @Test
    public void setiDList() {

        Integer expected = 3;
        Integer actual = idController.getIds().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getIds() {
        Assert.assertEquals(idController.getIds(), arr);
    }

    @Test
    public void listContains() {
       Id actual =  idController.ListContains("bobid");
       Id expected = idController.getIds().get(0);

       Assert.assertEquals(actual, expected);

    }

}