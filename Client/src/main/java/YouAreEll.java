import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.*;
import models.Id;
import models.Message;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();




    public YouAreEll (MessageController m, IdController j) {
        // used j because i seems awkward
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        TransactionController tc = new TransactionController();
        String urlString = tc.getRootURL()+mainurl;


        if(method == ("GET")) {
            Request request = new Request.Builder()
                    .url(urlString)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                String responseBody = response.body().string();

                if (mainurl.equals( "/ids")) {

//                    List<Id> results = mapper.readValue(responseBody,
//                            new TypeReference<List<Id>>() {} );
////
//                    ArrayList<Id>  = mapper.readValue(responseBody, ArrayList.class);
//                    idCtrl.setMyId(names);
//                    return idCtrl.getMyId().get(0).getName();
                    return responseBody;
                }else if (mainurl.equals("/messages")){
//                    HashSet<Message> messages = mapper.readValue(responseBody, HashSet.class);
//                    msgCtrl.setMessagesSeen(messages);
                    return responseBody;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        else if(method.equals("POST")){
            RequestBody body = RequestBody.create(JSON, jpayload);
            Request request = new Request.Builder()
                    .url(urlString)
                    .post(body)
                    .build();
            try(Response response = client.newCall(request).execute()){
                return response.body().string();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return "data";
    }
}
