package SortingExample_Scott;

public class person {
	String name;
	int age;
	boolean sortme = false;
	
	public person(String n, int a) {
		name = n;
		age = a;		
	}
	
	public String toString(){
		return name +  " " + Integer.toString(age);
	}
	
}