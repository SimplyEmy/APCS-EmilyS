package Appointment_Interface;

public class SelectSportAppt implements Appointment{
	String day;
	String name;

	// constructor
	public SelectSportAppt(String d, String n) {
		day = d;
		name = n;
	}

	// for Appointment interface: name()
	public String name() {
		return name;
	}

	// for Appointment interface: place()
	public String place() {
		return "Seattle Prep Field";
	}

	// for Appointment interface: dayOfWeek()
	public String dayOfWeek() {
		return day;
	}

}
