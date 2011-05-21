package br.com.robertokl.chat.commoms.actions;

import br.com.robertokl.chat.commoms.constants.Actions;

/**
 * @author     klein
 */
public abstract class ActionFactory {

    public Action build(String data) {
	data = initialize(data);
	String action = data.split(";")[0];
	String[] params = data.replace(action + ";", "").split(";");
	Action a = build(Actions.findAction(action), params);
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
	} else if (action == Actions.ERROR) {
	    a = getErrorAction();
	} else if (action == Actions.ADMIN_LOGIN) {
	    a = getAdminLoginAction();
	} else if (action == Actions.KICK) {
	    a = getKickAction();
	} else if (action == Actions.MUTE) {
	    a = getMuteAction();
	}else if (action == Actions.UNMUTE) {
	    a = getUnmuteAction();
	}
	if (a != null)
	    a.setParams(params);
	return a;
    }

    protected abstract String initialize(String data);

    /**
	 * @uml.property  name="privateMessageAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getPrivateMessageAction();

    /**
	 * @uml.property  name="sendMessageAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getSendMessageAction();

    /**
	 * @uml.property  name="clientLoginAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getClientLoginAction();

    /**
	 * @uml.property  name="statusChangeAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getStatusChangeAction();

    /**
	 * @uml.property  name="errorAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getErrorAction();

    /**
	 * @uml.property  name="adminLoginAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getAdminLoginAction();

    /**
	 * @uml.property  name="kickAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getKickAction();
    
    /**
	 * @uml.property  name="muteAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getMuteAction();
    
    /**
	 * @uml.property  name="unmuteAction"
	 * @uml.associationEnd  readOnly="true"
	 */
    protected abstract Action getUnmuteAction();
}
