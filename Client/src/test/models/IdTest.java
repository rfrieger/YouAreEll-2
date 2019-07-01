package models;

import org.junit.Assert;

import static org.junit.Assert.*;

public class IdTest {
    Id id = new Id("bob", "stuff", "123");

    @org.junit.Test
    public void getUserid() {
        String expected = "stuff";
        String actual = id.getUserid();

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void setUserid() {
        id.setUserid("12345");

        String expected = "12345";
        String actual = id.getUserid();

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getName() {
        String expected = "bob";
        String actual = id.getName();

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void setName() {
        id.setName("jimbo");
        String expected = "jimbo";
        String actual = id.getName();

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void getGithub() {
        String expected = "123";
        String actual = id.getGithub();

        Assert.assertEquals(expected, actual);
    }

    @org.junit.Test
    public void setGithub() {
        id.setGithub("yikes");

        String expected = "yikes";
        String actual = id.getGithub();

        Assert.assertEquals(expected, actual);
    }
}