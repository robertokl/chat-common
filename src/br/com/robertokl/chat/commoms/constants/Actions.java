package br.com.robertokl.chat.commoms.constants;

public enum Actions {

    CLIENT_LOGIN("clientLogin"),
    BROADCAST_MESSAGE("broadCastMessage"),
    STATUS_CHANGE("statusChange"),
    PRIVATE_MESSAGE("privateMessage");
    
    private String action;

    private Actions(String action) {
	this.action = action;
    }
    
    public String getAction() {
	return action;
    }
    
    public static Actions getServerAction(String action) {
	for (int i = 0; i < values().length; i++) {
	    if(values()[i].getAction().equals(action)){
		return values()[i];
	    }
	}
	return null;
    }
    
}