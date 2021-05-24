package craftintuit.intuitservice.entity;


public class Response {
	boolean success;
	String mesg;
	public Response(boolean b, String mesg) {
		super();
		success = b;
		this.mesg = mesg;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public Response() {
		
	}
	
	public Response(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
