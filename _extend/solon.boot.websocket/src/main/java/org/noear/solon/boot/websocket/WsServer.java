package org.noear.solon.boot.websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.noear.solon.core.*;
import org.noear.solon.xsocket.*;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("unchecked")
public class WsServer extends WebSocketServer {
    private Charset _charset = StandardCharsets.UTF_8;

    private XSocketContextHandler handler;
    private XListener listener;

    public WsServer(int port) {
        super(new InetSocketAddress(port));
        handler = new XSocketContextHandler(XMethod.WEBSOCKET);
        listener = XListenerProxy.getInstance();
    }

    @Override
    public void onStart() {
        System.out.println("Solon.Server:Websocket onStart...");
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake shake) {
        if (listener != null) {
            listener.onOpen(_SocketSession.get(conn));
        }
    }

    @Override
    public void onClose(WebSocket conn, int i, String s, boolean b) {
        if (listener != null) {
            listener.onClose(_SocketSession.get(conn));
            _SocketSession.remove(conn);
        }
    }

    @Override
    public void onMessage(WebSocket conn, String data) {
        try {
            XSession session = _SocketSession.get(conn);
            XMessage message = XMessage.wrap(conn.getResourceDescriptor(), data.getBytes(_charset));

            if (listener != null) {
                listener.onMessage(session, message);
            }

            if (message.getHandled() == false) {
                handler.handle(session, message, true);
            }

        } catch (Throwable ex) {
            XEventBus.push(ex);
        }
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer data) {
        try {
            XSession session = _SocketSession.get(conn);
            XMessage message = XMessage.wrap(conn.getResourceDescriptor(), data.array());

            if (listener != null) {
                listener.onMessage(session, message);
            }

            if (message.getHandled() == false) {
                handler.handle(session, message, false);
            }
        } catch (Throwable ex) {
            XEventBus.push(ex);
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        if (listener != null) {
            listener.onError(_SocketSession.get(conn), ex);
        } else {
            XEventBus.push(ex);
        }
    }
}
