package com.bo.trade.websocket;

import com.bo.trade.service.ISession;
import com.google.gson.JsonObject;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.UUID;

@Log4j2
@Service
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("connection closed with status: {}", status.getCode());
        SessionManager.closeSession(session.getId());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String userId = UUID.randomUUID().toString();
        ISession client = new SpringWSSession(session);
        SessionManager.removeEmptyConn();
        SessionManager.addSession(userId, client);
        log.info("Add session: {}", session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, @NonNull TextMessage msg) throws Exception {
        SessionManager.setLastAction(session.getId());
        JsonObject jo = new JsonObject();
        jo.addProperty("id", session.getId());
        jo.addProperty("status", 200);
        session.sendMessage(new TextMessage(jo.toString()));
    }
}
