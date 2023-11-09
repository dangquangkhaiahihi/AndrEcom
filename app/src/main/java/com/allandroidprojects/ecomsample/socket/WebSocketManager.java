package com.allandroidprojects.ecomsample.socket;

import com.allandroidprojects.ecomsample.ui.activity.ChatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.ArrayList;
import java.util.List;

public class WebSocketManager extends WebSocketListener {
    private static final String SOCKET_URL = "wss://free.blr2.piesocket.com/v3/1?api_key=pGs6AYIdIgisYsKsNDsbxht5BY3nC9J166X4pPbe&notify_self=1";

    private WebSocket webSocket;
    private ChatActivity chatActivity;
    private List<String> messageList = new ArrayList<>();

    public WebSocketManager(ChatActivity chatActivity) {
        this.chatActivity = chatActivity;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(SOCKET_URL).build();
        webSocket = client.newWebSocket(request, this);
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        // Handle when the connection is opened
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
        // Handle when a text message is received
        messageList.add(text);

        // Pass the updated messages to ChatActivity
        chatActivity.showChatHistory(getAllMessagesAsString());
    }

    public String getAllMessagesAsString() {
        // Concatenate all messages into a single string
        StringBuilder allMessages = new StringBuilder();
        for (String message : messageList) {
            allMessages.append(message).append("\n");
        }
        return allMessages.toString();
    }

    public void requestChatHistory() {
        webSocket.send("request_chat_history");
    }

    public void sendMessage(String message) {
        webSocket.send(message);
    }

    public void closeConnection() {
        webSocket.close(1000, "Goodbye!");
    }
}
