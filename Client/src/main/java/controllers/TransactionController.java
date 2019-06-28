package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;
import okhttp3.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class TransactionController {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();
    private String rootURL = "http://zipcode.rocks:8085";
    private String responseBody;
    private MessageController msgCtrl;
    private IdController idCtrl;
    private String main;
    private String method;
    private String Jpayload;

    public TransactionController(String main, String method, String Jpayload, MessageController msgCtrl, IdController idCtrl ) throws IOException {
        this.msgCtrl = msgCtrl;
        this.idCtrl =idCtrl;
        this.main = main;
        this.method =method;
        this.Jpayload = Jpayload;
    }

    public String constructUrl() {
        return rootURL + main;
    }


    public void setJSONResponse() {
        Request request = new Request.Builder()
                .url(constructUrl())
                .build();
        try (Response response = client.newCall(request).execute()) {
            this.responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getObjectsToControllers()  {
        switch (main) {
            case "/ids": {
                    setJSONResponse();
                try {
                    idCtrl.setIdArrayList(mapper.readValue(responseBody, new TypeReference<List<Id>>(){}));
                    idCtrl.print();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "/messages":{

                setJSONResponse();
                try {
                    msgCtrl.setMessagesSeen(mapper.readValue(responseBody, new TypeReference<HashSet<Message>>(){}));
                    msgCtrl.print();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
                System.out.println("stuff");
                break;
        }
    }

    public String PostRespose() throws IOException {

        RequestBody body = RequestBody.create(JSON, Jpayload);

        Request request = new Request.Builder()
                .url(constructUrl())
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
            return response.body().string();

    }
}