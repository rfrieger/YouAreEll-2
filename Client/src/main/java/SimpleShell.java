import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.IdController;
import controllers.MessageController;
import models.Id;
import models.Message;

// Simple Shell is a Console view for YouAreEll.
public class SimpleShell {


    public static void prettyPrint(String output) {
//
    }
    public static void main(String[] args) throws java.io.IOException {
        ObjectMapper mapper = new ObjectMapper();
        MessageController msgCont = new MessageController();
        IdController idController = new IdController();
        YouAreEll webber = new YouAreEll(msgCont, idController);




        String commandLine;
        BufferedReader console = new BufferedReader
                (new InputStreamReader(System.in));

        ProcessBuilder pb = new ProcessBuilder();
        List<String> history = new ArrayList<>();
        int index = 0;
        //we break out with <ctrl c>
        while (true) {
            //read what the user enters
            System.out.println("cmd? ");
            commandLine = console.readLine();

            //input parsed into array of strings(command and arguments)
            String[] commands = commandLine.split(" ");
            List<String> list = new ArrayList<String>();

            //if the user entered a return, just loop again
            if (commandLine.equals(""))
                continue;
            if (commandLine.equals("exit")) {
                System.out.println("bye!");
                break;
            }

            //loop through to see if parsing worked
            for (int i = 0; i < commands.length; i++) {
                //System.out.println(commands[i]); //***check to see if parsing/split worked***
                list.add(commands[i]);

            }
            System.out.print(list); //***check to see if list was added correctly***
            history.addAll(list);
            try {
                //display history of shell with index
                if (list.get(list.size() - 1).equals("history")) {
                    for (String s : history)
                        System.out.println((index++) + " " + s);
                    continue;
                }

                // Specific Commands.

                // ids
                if (list.contains("ids") && list.size() == 1) {
                    String results = webber.get_ids();
                    continue;
                }
                //ids new name github
                if(list.contains("ids") && list.contains("new")){
                    String name = list.get(2);
                    String github = list.get(3);
                    Id newUser = new Id(name, github);
                    String newUserInfo = mapper.writeValueAsString(newUser);
                    webber.MakeURLCall("/ids", "POST", newUserInfo);

                    continue;
                }
                //change githubId tobechangedto
                if(list.contains("change") && list.size()==3){
                    String gitHub = list.get(1);
                    String toChangeTo = list.get(2);
                    if (idController.ListContains(gitHub) != null){
                        Id toChange = idController.ListContains(gitHub);
                        toChange.setName(toChangeTo);
                        String jsonpayload = mapper.writeValueAsString(toChange);
                        webber.MakeURLCall("/ids", "PUT", jsonpayload);
                    }
                    continue;
                }


                // messages
                if (list.contains("messages") && (list.size()==1)) {
                    String results = webber.get_messages();

                    continue;
                }
                //get messages between userID and friendID
                if(list.contains("get") && (list.contains("between"))){
                    String name = list.get(3);
                    String friendID = list.get(5);
                    webber.MakeURLCall("/ids/"+name+"/from/" + friendID, "GET", "");
                    continue;
                }

                //send sender message
                if(list.contains("send") && (list.size() == 3)){
                    String name = list.get(1);
                    String message = list.get(2);
                    Message newMessage = new Message(message, name);
                    String messageToSend = mapper.writeValueAsString(newMessage);
                    webber.MakeURLCall("/ids/"+name+"/messages", "POST", messageToSend);
                    continue;
                }
                //get messages userID
                if(list.contains("messages") && list.contains("get")){
                    String userId = list.get(2);
                    webber.MakeURLCall("/ids/" + userId + "/messages", "GET", "");
                    continue;

                }


                //!! command returns the last command in history
                if (list.get(list.size() - 1).equals("!!")) {
                    pb.command(history.get(history.size() - 2));

                }//!<integer value i> command
                else if (list.get(list.size() - 1).charAt(0) == '!') {
                    int b = Character.getNumericValue(list.get(list.size() - 1).charAt(1));
                    if (b <= history.size())//check if integer entered isn't bigger than history size
                        pb.command(history.get(b));
                } else {
                    pb.command(list);
                }

                // wait, wait, what curiousness is this?
                Process process = pb.start();

                //obtain the input stream
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                //read output of the process
                String line;
                while ((line = br.readLine()) != null)
                    System.out.println(line);
                br.close();


            }

            //catch ioexception, output appropriate message, resume waiting for input
            catch (IOException e) {
                System.out.println("Input Error, Please try again!");
            }
            // So what, do you suppose, is the meaning of this comment?
            /** The steps are:
             * 1. parse the input to obtain the command and any parameters
             * 2. create a ProcessBuilder object
             * 3. start the process
             * 4. obtain the output stream
             * 5. output the contents returned by the command
             */

        }


    }

}