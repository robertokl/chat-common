package br.com.robertokl.chat.commoms.handlers;

import java.net.Socket;

public interface IncomingMessageHandler {
    void handle(String data, Socket client) throws Exception;
}
