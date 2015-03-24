package Date_Class;

//Seattle Prep CS class
//12/14/2014
public class Date {
	// data fields
	public int month;
	public int day;
	public int year;
	public int printFormat;
	public int monthName;

	// constructor
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
		printFormat = 1;
	}

	// convert to string, with slash
	public String toStringWithSlash() {
		return month + "/" + day + "/" + year;
	}

	// convert to string, with dash
	public String toStringWithDash() {
		return month + "-" + day + "-" + year;
	}
	
	//convert to string with full date
	public String toStringWithFullDate() {
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int name = month - 1;
		String monthName = monthNames[name];
		
		if (day == 1)
			return monthName + " " + day + "st, " + year;
		else if(day == 2)
			return monthName + " " + day + "nd, " + year;
		else if(day == 3)
			return monthName + " " + day + "rd, " + year;
		else
			return monthName + " " + day + "th, " + year;
		
	}

	// set to print with slash
	public void setPrintWithSlash() {
		printFormat = 1;
	}

	// set to print with dash
	public void setPrintWithDash() {
		printFormat = 2;
	}
	
	// set to print with dash
	public void setPrintWithFullDate() {
		printFormat = 3;
	}

	// convert to String based on setting
	public String toString() {
		if (printFormat == 1)
			return toStringWithSlash();
		else if(printFormat == 2)
			return toStringWithDash();
		else
			return toStringWithFullDate();
	}

	// date comparison
	public int compare(Date d) {
		// check year
		if (year < d.year)
			return -1;
		else if (year > d.year)
			return 1;

		// equal years, check month
		if (month < d.month)
			return -1;
		else if (month > d.month)
			return 1;

		// equal month, check day
		if (day < d.day)
			return -1;
		else if (day > d.day)
			return 1;
		else
			return 0;
	}
}


