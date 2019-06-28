import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.*;
import models.Id;
import models.Message;
import okhttp3.*;

import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() throws IOException {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() throws IOException {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) throws IOException {
        TransactionController tc = new TransactionController(mainurl, method,jpayload, msgCtrl, idCtrl);

        if(method == ("GET")) {
            tc.getObjectsToControllers();
        }

        else if(method.equals("POST")){
                tc.PostRespose();

        }
        return "data";
    }
}
