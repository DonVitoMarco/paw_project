package pl.thewalkingcode.component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.thewalkingcode.util.ExchangeWebSocketListener;

import java.util.logging.Logger;

@Component
public class ScheduledTask {

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    @Scheduled(fixedRate = 10000)
    public void saveRating() {
        LOG.info("save rating method");
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("ws://localhost:8081/exchange_websocket/websocket").build();
        ExchangeWebSocketListener listener = new ExchangeWebSocketListener();

        WebSocket ws = client.newWebSocket(request, listener);
        ws.close(1000, null);
    }

}
