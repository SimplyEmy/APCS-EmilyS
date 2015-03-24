package Person_Class;

public class Person {
	public String firstname;
	public String lastname;
	
	void setFirstName(String s){
		firstname = s;
	}
	
	void setLastName(String s){
		lastname = s;
	}
	
	String getFullName(){
		String fullname = firstname + " " + lastname;
		
		return fullname;
		
	}

}
