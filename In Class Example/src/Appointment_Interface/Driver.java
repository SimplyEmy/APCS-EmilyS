package Appointment_Interface;
// Seattle Prep CS class
// 2/24/2015
//
public class Driver {

	// main function
	public static void main(String[] args) {
		// create array of appointments
		Appointment[] appt = new Appointment[8];
		appt[0] = new SchoolAppt("Tuesday", "Drama");
		appt[1] = new SchoolAppt("Thursday", "Drama");
		appt[2] = new SchoolAppt("Friday", "Drama");
		appt[3] = new SchoolAppt("Saturday", "CS office hours");
		appt[4] = new ChurchAppt("Mass");
		appt[5] = new ChurchAppt("Youth group");
		appt[6] = new SelectSportAppt("Monday", "Soccer");
		appt[7] = new SelectSportAppt("Thursday", "Soccer");

		// print schedule
		printSchedule(appt);
	}

	// names for days of the week
	static String[] daysWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

	// print a schedule based on array of appointments
	public static void printSchedule(Appointment[] appt) {
		// check each day
		for (int dayIdx = 0; dayIdx < daysWeek.length; dayIdx++) {
			boolean activitySeen = false;
			System.out.println(daysWeek[dayIdx] + ":");

			// print all appointments for given day
			for (int apptIdx = 0; apptIdx < appt.length; apptIdx++) {
				if (daysWeek[dayIdx].equalsIgnoreCase(appt[apptIdx].dayOfWeek())) {
					System.out.println("  " + appt[apptIdx].name() + ", " + appt[apptIdx].place());
					activitySeen = true;
				}
			}

			// if no appointment for that day, say so
			if (!activitySeen) {
				System.out.println("  >>No appointments");
			}
		}
	}
}
