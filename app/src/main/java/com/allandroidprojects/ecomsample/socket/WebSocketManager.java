package com.allandroidprojects.ecomsample.socket;

import com.allandroidprojects.ecomsample.ui.activity.ChatActivity;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebSocketManager extends WebSocketListener {
    private static final String SOCKET_URL = "wss://free.blr2.piesocket.com/v3/1?api_key=pGs6AYIdIgisYsKsNDsbxht5BY3nC9J166X4pPbe&notify_self=1";

    private WebSocket webSocket;
    private ChatActivity chatActivity;
    public WebSocketManager(ChatActivity chatActivity) {
        this.chatActivity = chatActivity; // Khởi tạo biến ChatActivity
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("wss://free.blr2.piesocket.com/v3/1?api_key=pGs6AYIdIgisYsKsNDsbxht5BY3nC9J166X4pPbe&notify_self=1").build();
        webSocket = client.newWebSocket(request, this);
    }
    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        // Xử lý khi kết nối mở
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        super.onMessage(webSocket, text);
        // Xử lý khi nhận được tin nhắn văn bản
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        super.onMessage(webSocket, bytes);
        // Xử lý khi nhận được tin nhắn dạng byte
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        super.onClosing(webSocket, code, reason);
        // Xử lý khi kết nối đang đóng
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        super.onClosed(webSocket, code, reason);
        // Xử lý khi kết nối đã đóng
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        // Xử lý khi xảy ra lỗi
    }

    public void sendMessage(String message) {
        webSocket.send(message);
    }

    public void closeConnection() {
        webSocket.close(1000, "Goodbye!");
    }
}
