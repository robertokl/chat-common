package br.com.robertokl.chat.commoms.handlers;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import br.com.robertokl.chat.commoms.actions.Action;
import br.com.robertokl.chat.commoms.actions.ActionFactory;


public class IncomingMessageListener implements Runnable {

    private Socket client;

    private ActionFactory factory;

    public IncomingMessageListener(Socket client, ActionFactory factory) {
	this.client = client;
	this.factory = factory;
    }

    public void run() {
	try {
	    DataInputStream in = new DataInputStream(new BufferedInputStream(client
		    .getInputStream()));
	    while (true) {
		String data = in.readUTF();
		Action a = factory.build(data);
		a.setClient(client);
		a.execute();
	    }
	} catch (IOException e) {
	    try {
		client.close();
	    } catch (IOException e1) {
		e1.printStackTrace();
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
