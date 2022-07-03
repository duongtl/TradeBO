package com.bo.trade.service;

public interface ISession {
    String getId();

    boolean send(Object data);

    long getLastTime();

    void setLastTime(long lastTime);

    void disconnect();

    void close();

    boolean isOpen();
}
