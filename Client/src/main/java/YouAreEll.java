import controllers.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    OkHttpClient client = new OkHttpClient();



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
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        else if(method.equals("POST")){
//            RequestBody body = RequestBody.create(JSON, jpayload);
//            Request request = new Request.Builder()
//                    .url(urlString)
//                    .post(body)
//                    .build();
//            try(Response response = client.newCall(request).execute()){
//                return response.body().string();
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
        return "nada";
    }
}
