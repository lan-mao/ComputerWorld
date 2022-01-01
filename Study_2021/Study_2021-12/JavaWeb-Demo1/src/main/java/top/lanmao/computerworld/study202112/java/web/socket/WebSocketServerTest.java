package top.lanmao.computerworld.study202112.java.web.socket;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Create Date 2021/12/17 11:5:45 <br>
 *
 * @author lan-mao.top <br>
 * @version 1.0
 * <br>
 */

public class WebSocketServerTest {
    public static void main(String[] args) {
        WebSocket.Listener listener = new WebSocket.Listener() {
            List<CharSequence> parts = new ArrayList<>();
            CompletableFuture<?> accumulatedMessage = new CompletableFuture<>();

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence message, boolean last) {
                parts.add(message);
                webSocket.request(1);
                if (last) {
                    processWholeText(parts);
                    parts = new ArrayList<>();
                    accumulatedMessage.complete(null);
                    CompletionStage<?> cf = accumulatedMessage;
                    accumulatedMessage = new CompletableFuture<>();
                    return cf;
                }
                return accumulatedMessage;
            }
        };
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> ws = client.newWebSocketBuilder().buildAsync(URI.create("ws://websocket.example.com"), listener);
    }

    private static void processWholeText(List<CharSequence> parts) {

    }
}