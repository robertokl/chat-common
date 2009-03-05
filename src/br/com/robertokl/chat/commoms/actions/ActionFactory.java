package br.com.robertokl.chat.commoms.actions;

import br.com.robertokl.chat.commoms.constants.Actions;

public abstract class ActionFactory {

    public Action build(String data) {
	data = initialize(data);
	String action = data.split(";")[0];
	String[] params = data.replace(action + ";", "").split(";");
	Action a = build(Actions.getServerAction(action), params);
	return a;
    }

    private Action build(Actions action, String[] params) {
	Action a = null;
	if (action == Actions.CLIENT_LOGIN) {
	    a = getClientLoginAction();
	} else if (action == Actions.BROADCAST_MESSAGE) {
	    a = getSendMessageAction();
	} else if (action == Actions.STATUS_CHANGE) {
	    a = getStatusChangeAction();
	} else if (action == Actions.PRIVATE_MESSAGE) {
	    a = getPrivateMessageAction();
	}
	if (a != null)
	    a.setParams(params);
	return a;
    }

    protected abstract String initialize(String data);
    
    protected abstract Action getPrivateMessageAction();

    protected abstract Action getSendMessageAction();

    protected abstract Action getClientLoginAction();

    protected abstract Action getStatusChangeAction();

}
