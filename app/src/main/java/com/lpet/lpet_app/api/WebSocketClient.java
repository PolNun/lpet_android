package com.lpet.lpet_app.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class WebSocketClient {
    private static final String BASE_WS_URL = "ws://10.0.2.2:8081/chat";

    private static WebSocketClient instance;
    private final OkHttpClient client;
    private WebSocket webSocket;

    private WebSocketClient() {
        client = new OkHttpClient();
    }

    public static WebSocketClient getInstance() {
        if (instance == null) {
            instance = new WebSocketClient();
        }
        return instance;
    }

    public void connectWebSocket(WebSocketListener listener) {
        Request request = new Request.Builder()
                .url(BASE_WS_URL)
                .build();

        webSocket = client.newWebSocket(request, listener);
    }

    public void disconnectWebSocket() {
        if (webSocket != null) {
            webSocket.close(1000, "Goodbye, WebSocket!");
        }
    }
}
