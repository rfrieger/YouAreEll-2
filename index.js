import MessageService from "./message-service.js";

let userId = "rfrieger";
const messageService = new MessageService;
const form = document.getElementById("new-message-form");
const btn = document.getElementById("btn");


window.addEventListener("load", function () {
    document.getElementById("greeting").innerHTML = `Welcome ${userId}!`;
    messageService.getAllMessages()
        .then(successCallback, errorCallback);

    function successCallback(response) {
        populateThread(response);
    }

    function errorCallback(response) {
        console.log(response);
    }
});



function populateThread(messages) {
    messages.forEach(message => {
        addMessageToThread(message);
    })
}




btn.addEventListener("click", function(){
        event.preventDefault();
        const data = {
            fromid: userId,
            message: form.message.value
        };

        messageService.createNewMessage(data)
            .then(successCallback, errorCallback);

        function successCallback(response) {
           addMessageToThread(response);
        }

        function errorCallback(response) {
            console.log(response);
        }
        document.getElementById("textarea").value = ""
    });


function addMessageToThread(message) {
    console.log("add message test")
    const messageListItem = document.createElement("li");
    const userIdHeading = document.createElement("h3");
    const messageParagraph = document.createElement("p");
    const messageContent = document.createTextNode(message.message);
    const userIdContent = document.createTextNode(message.fromid);
    userIdHeading.appendChild(userIdContent);
    messageParagraph.appendChild(messageContent);
    messageListItem
        .appendChild(userIdHeading)
        .appendChild(messageParagraph);
    document.getElementById("message-list").appendChild(messageListItem);
}



