package Appointment_Interface;
// Seattle Prep CS class
// 2/24/2015
//

// church appointment
public class ChurchAppt implements Appointment {
	String name;

	// constructor
	public ChurchAppt(String n) {
		name = n;
	}

	// for Appointment interface: name()
	public String name() {
		return name;
	}

	// for Appointment interface: place()
	public String place() {
		return "St Louise";
	}

	// for Appointment interface: dayOfWeek()
	public String dayOfWeek() {
		return "Sunday";
	}

}
