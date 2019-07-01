package models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTest {
    Message message= new Message("1234","10/20", "jen","bob", "heyo");
    @Test
    public void getSequence() {
        String expected = "1234";
        String actual = message.getSequence();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSequence() {
        message.setSequence("4321");

        String expected = "4321";
        String actual = message.getSequence();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTimestamp() {
        String expected = "10/20";
        String actual = message.getTimestamp();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void setTimestamp() {
        message.setTimestamp("1/2");

        String expected = "1/2";
        String actual = message.getTimestamp();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFromid() {
        String expected = "jen";
        String actual = message.getFromid();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void setFromid() {
        message.setFromid("jimbo");

        String expected = "jimbo";
        String actual = message.getFromid();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getToid() {
        String expected = "bob";
        String actual = message.getToid();

        Assert.assertEquals(expected, actual);
        }


    @Test
    public void setToid() {
        message.setToid("joe");

        String expected = "joe";
        String actual = message.getToid();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMessage() {
        String expected = "heyo";
        String actual = message.getMessage();

        Assert.assertEquals(expected, actual);
        }


    @Test
    public void setMessage() {
        message.setMessage("1/2");

        String expected = "1/2";
        String actual = message.getMessage();

        Assert.assertEquals(expected, actual);
    }
}