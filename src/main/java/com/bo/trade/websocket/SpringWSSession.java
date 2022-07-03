package com.bo.trade.websocket;

import com.bo.trade.service.ISession;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Log4j2
public class SpringWSSession implements ISession {

    private final WebSocketSession client;
    private final String id;
    private boolean ssClosed = false;
    private long lastTime;

    public SpringWSSession(WebSocketSession client) {
        this.client = client;
        this.id = client.getId();
        this.lastTime = System.currentTimeMillis();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean send(Object data) {
        // send từ Server -> Client
        // Client nhận msg, cập nhật lastTime để giữ kết nối.
        // -> Giờ làm tiếp phần Client send lên thì cũng phải giữ kết nối.
        //log.info("send: {}", data);
        if (client != null && client.isOpen() && !ssClosed) {
            try {
                String text = (String) data;
                client.sendMessage(new TextMessage(text));
                this.lastTime = System.currentTimeMillis();
                return true;
            } catch (Exception ex) {
                log.error("Send message ex: " + ex);
                return false;
            }
        }

        try {
            if (client != null) {
                client.close();
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    @Override
    public long getLastTime() {
        return this.lastTime;
    }

    @Override
    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public synchronized void disconnect() {
        if (this.ssClosed) {
            return;
        }
        this.ssClosed = true;
        if (client != null) {
            try {
                client.close();
            } catch (Throwable e) {
                log.error("Ex: ", e);
            }
        }
    }

    @Override
    public void close() {
        this.disconnect();
    }

    @Override
    public boolean isOpen() {
        return !ssClosed && client != null && client.isOpen();
    }
}
