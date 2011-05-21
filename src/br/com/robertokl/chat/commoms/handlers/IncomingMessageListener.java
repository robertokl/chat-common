package br.com.robertokl.chat.commoms.handlers;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import br.com.robertokl.chat.commoms.actions.Action;
import br.com.robertokl.chat.commoms.actions.ActionFactory;
import br.com.robertokl.chat.commoms.helpers.Encriptor;

public class IncomingMessageListener implements Runnable {

	/**
	 * @uml.property name="client"
	 */
	private Socket client;

	/**
	 * @uml.property name="factory"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private ActionFactory factory;

	private String key;

	public IncomingMessageListener(Socket client, ActionFactory factory,
			String key) {
		this.client = client;
		this.factory = factory;
		this.key = key;
	}

	public void run() {
		try {
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					client.getInputStream()));
			while (true) {
				String data = in.readUTF();
				data = Encriptor.decode(key, data);
				System.out.println(data);
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
