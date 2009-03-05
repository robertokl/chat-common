package br.com.robertokl.chat.commoms.actions;

import java.net.Socket;

public interface Action {
    void execute() throws Exception;
    void setParams(String[] params);
    void setClient(Socket client);
}
