package enums;

public enum StatusCode {	
	
	CODE_200(200,""),
	CODE_201(201,""),
	CODE_400(400, "Missing required field: name"),
    CODE_401(401, "Invalid access token");
	
	private final int CODE;
	private final String MESSAGE;
	
    StatusCode(int CODE, String MESSAGE) {
	   
	   this.CODE = CODE;
	   this.MESSAGE= MESSAGE;
   }
    
    public int getCode() {
    	return CODE;
    	
    }
    
    public String getMsg() {
    	return MESSAGE;
    	
    }
}
