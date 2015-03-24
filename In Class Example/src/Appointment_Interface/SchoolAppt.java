package Appointment_Interface;
// Seattle Prep CS class
// 2/24/2015
//

// school appointment
public class SchoolAppt implements Appointment {
	String day;
	String name;

	// constructor
	public SchoolAppt(String d, String n) {
		day = d;
		name = n;
	}

	// for Appointment interface: name()
	public String name() {
		return name;
	}

	// for Appointment interface: place()
	public String place() {
		return "Seattle Prep";
	}

	// for Appointment interface: dayOfWeek()
	public String dayOfWeek() {
		return day;
	}

}
