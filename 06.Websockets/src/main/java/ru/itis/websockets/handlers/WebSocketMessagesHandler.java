package ru.itis.websockets.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.websockets.dto.Message;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebSocketMessagesHandler extends TextWebSocketHandler {

    private static final Map<String, WebSocketSession> sessions = new HashMap<>();

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonMessage) throws Exception {
        Message message = objectMapper.readValue(jsonMessage.getPayload(), Message.class);

        if (!sessions.containsKey(message.getFrom())) {
            sessions.put(message.getFrom(), session);
        }

        for (WebSocketSession currentSession : sessions.values()) {
            currentSession.sendMessage(jsonMessage);
        }
    }
}
