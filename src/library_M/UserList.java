package library_M;

public class UserList {
	
	private String name;
	private String userId;
	private String password;
	private String phoneNum;
	private String mail;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getName(){
		
		return name;
	}

	public String getID(){
		
		return userId;
	}

	public String getPass(){
		
		return password;
	}

	public String getPhone(){
		
		return phoneNum;
	}

	public String getMail(){
		
		return mail;
	}
	
	public void setName(String name){ this.name=name;}
	public void setId(String id){ this.userId=id;}
	public void setPass(String pass){ this.password=pass;}
	public void setPhone(String phone){ this.phoneNum=phone;}
	public void setMail(String mail){ this.mail=mail;}

	
}
