package pl.thewalkingcode.util;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.util.logging.Logger;

public final class ExchangeWebSocketListener extends WebSocketListener {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        LOG.info("WebSocket - Open");
        webSocket.send("sync server");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        LOG.info("WebSocket - Message : "  + text);
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(1000, null);
        LOG.info("WebSocket - Close");
    }

}
