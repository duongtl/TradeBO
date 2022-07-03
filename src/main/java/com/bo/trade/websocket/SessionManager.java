package com.bo.trade.websocket;

import com.bo.trade.service.ISession;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Log4j2
public class SessionManager {

    private static final ConcurrentHashMap<String, Set<ISession>> uidSessionMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ISession> SESSIONS = new ConcurrentHashMap<>();

    private static final ReentrantLock LOCK = new ReentrantLock(true);
    private static final ReentrantLock LOCK_WALLET = new ReentrantLock(true);

    private SessionManager() {

    }

    private static int _sendTo(String to, String msg) {
        if (uidSessionMap.isEmpty()) {
            return -1;
        }
        Set<ISession> list = uidSessionMap.get(to.toLowerCase());
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int count = 0;
        for (ISession session : list) {
            boolean sent = session.send(msg);
            if (sent) {
                count++;
            }
        }
        log.debug("Total sent to: {}, is: {}", to, count);
        return count;
    }

    public static void sendAll(String msg) {
        if (SESSIONS.isEmpty()) {
            return;
        }
        long count = 0;
        for (ISession session : SESSIONS.values()) {
            boolean sent = session.send(msg);
            if (sent) {
                count++;
            }
        }
        log.debug("Total sent: {}", count);
    }

    public static void addSession(String userId, ISession session) {
        SESSIONS.put(session.getId(), session);
        if (Strings.isNotBlank(userId)) {
            LOCK.lock();
            try {
                _addSessionToMapConn(userId, session);
            } finally {
                LOCK.unlock();
            }
        }
    }

    private static void _addSessionToMapConn(String key, ISession session) {
        Set<ISession> sessions = uidSessionMap.get(key);
        if (sessions == null || sessions.isEmpty()) {
            sessions = new HashSet<>();
            sessions.add(session);
            uidSessionMap.put(key, sessions);
            return;
        }
        sessions.add(session);
    }

    //    // check hbc
//    public static void checkHeartbeat() {
//
//        log.info("check heartbeat: {} sessions", SESSIONS.size());
//        if (SESSIONS.isEmpty()) {
//            return;
//        }
//
//        long now = System.currentTimeMillis();
//        Set<String> removeSessions = new HashSet<>();
//        for (Map.Entry<String, ISession> entry : SESSIONS.entrySet()) {
//            ISession session = entry.getValue();
//            long lastTime = session.getLastTime();
//            if (now - lastTime > 3600000 || !session.isOpen()) {
//                log.info("session: {} time out -> disconnect", session.getId());
//                session.disconnect();
//                removeSessions.add(session.getId());
//            }
//        }
//
//        if (!removeSessions.isEmpty()) {
//
//            for (String id : removeSessions) {
//                SESSIONS.remove(id);
//            }
//
//            LOCK.lock();
//            try {
//                _removeClosedConnection(userSessionMap, removeSessions);
//            } finally {
//                LOCK.unlock();
//            }
//
//            LOCK_WALLET.lock();
//            try {
//                _removeClosedConnection(walletSessionMap, removeSessions);
//            } finally {
//                LOCK_WALLET.unlock();
//            }
//
//        }
//
//    }
//
//    private static void _removeClosedConnection(Map<String, Set<ISession>> mapConn, final Set<String> removed) {
//        for (Map.Entry<String, Set<ISession>> entry : mapConn.entrySet()) {
//            Set<ISession> sessions = entry.getValue();
//            if (sessions == null || sessions.isEmpty()) {
//                continue;
//            }
//            sessions.removeIf(s -> removed.contains(s.getId()));
//        }
//    }
//
//    // remove empty sessions
//    public static void removeEmptySessionList() {
//        log.info("Start clean sessions");
//        LOCK.lock();
//        try {
//            _removeEmptyConn(userSessionMap);
//        } finally {
//            LOCK.unlock();
//        }
//        LOCK_WALLET.lock();
//        try {
//            _removeEmptyConn(walletSessionMap);
//        } finally {
//            LOCK_WALLET.unlock();
//        }
//    }
//
    public static void removeEmptyConn() {
        if (uidSessionMap.isEmpty()) {
            return;
        }
        Set<String> removeUserIds = new HashSet<>();
        for (Map.Entry<String, Set<ISession>> entry : uidSessionMap.entrySet()) {
            Set<ISession> sessions = entry.getValue();
            if (sessions != null && sessions.isEmpty()) {
                removeUserIds.add(entry.getKey());
            }
        }
        if (!removeUserIds.isEmpty()) {
            for (String id : removeUserIds) {
                uidSessionMap.remove(id);
            }
        }
        log.info("Clean total {}", removeUserIds.size());
        log.info("Clean data {}", removeUserIds);
    }

    //
    public static void setLastAction(String id) {
        if (Strings.isBlank(id)) {
            return;
        }
        ISession session = SESSIONS.get(id);
        if (session != null) {
            session.setLastTime(System.currentTimeMillis());
        }
    }

    public static void closeSession(String id) {
        if (Strings.isBlank(id)) {
            return;
        }
        ISession session = SESSIONS.get(id);
        if (session != null) {
            session.close();
        }
    }
//
//    public static void monitorSession() {
//        int totalSession = SESSIONS.size();
//        int totalWallet = walletSessionMap.size();
//        int totalWalletEmpty = _countEmptyList(walletSessionMap);
//        log.info("Monitor totalSession: {}, totalWallet: {}, totalWalletEmpty: {}",
//                totalSession, totalWallet, totalWalletEmpty);
//    }
//
//    private static int _countEmptyList(Map<String, Set<ISession>> mapConn) {
//        int count = 0;
//        for (Map.Entry<String, Set<ISession>> e : mapConn.entrySet()) {
//            if (e.getValue().isEmpty()) {
//                count++;
//            }
//        }
//        return count;
//    }
}
