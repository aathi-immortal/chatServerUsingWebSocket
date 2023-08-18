package com.websocket.server.controller;

import java.util.ArrayList;


import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class GameWebsocketController extends TextWebSocketHandler {
    private ArrayList<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String strMessage = message.getPayload();
        strMessage = strMessage + " umpu la nee umpu";
        message = new TextMessage(strMessage);
        session.sendMessage(message);
        // for (WebSocketSession session_value : sessions) {
        // if (session_value.isOpen()) {
        // session_value.sendMessage(message);
        // }
        // }
    }

}
