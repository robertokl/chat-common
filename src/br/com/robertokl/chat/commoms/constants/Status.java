package br.com.robertokl.chat.commoms.constants;

public enum Status {
    AVAILABLE("Disponível"),
    UNAVAILABLE("Indisponível"),
    AWAY("Ausente"),
    BUSY("Ocupado");

    /**
	 * @uml.property  name="status"
	 */
    private String status;
    
    private Status(String status) {
	this.status = status;
    }

    /**
	 * @param  status
	 * @uml.property  name="status"
	 */
    public void setStatus(String status) {
	this.status = status;
    }

    /**
	 * @return
	 * @uml.property  name="status"
	 */
    public String getStatus() {
	return status;
    }
    
    public static Status getStatus(String status) {
	for (int i = 0; i < values().length; i++) {
	    if(values()[i].getStatus().equals(status)){
		return values()[i];
	    }
	}
	return null;
    }
}
