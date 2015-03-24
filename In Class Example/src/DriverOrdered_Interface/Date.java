package DriverOrdered_Interface;

// Seattle Prep CS class
// 12/16/2014
//
public class Date implements Ordered{
	// data fields
	private int month;
	private int day;
	private int year;
	private int printFormat; // 1 = slashes, 2 = dashes, 3 = long form

	// constructor from 3 integers
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
		printFormat = 1;
	}

	// constructor from string
	public Date(String s) {
		String[] w = s.split("/");
		month = Integer.parseInt(w[0]);
		day = Integer.parseInt(w[1]);
		year = Integer.parseInt(w[2]);
		printFormat = 1;
	}

	// year accessor
	public int getYear() {
		return year;
	}

	//implementing Ordered
	public boolean isSmallerThan(Ordered other){
		Date d = (Date) other;
		
		int numberAnswer = compare(d);
		
		if (numberAnswer == 1){
			return false;
		}else if (numberAnswer == -1){
			return true;
		}else{
			return false;
		}
		
		 
		
		//boolean x;
		
		
		/*
		if (this.year > d.year){
			x = false;
			
		}else if(this.year == d.year){
			if(this.month > d.month){
				x = false;
			} else if (this.month == d.month){
				if(this.day > d.day){
					x = false;
				}else if (this.day < d.day){
					x = true;
				}
			}
		}*/
			
	
	}
	
	
	// convert to string, with slash
	private String toStringWithSlash() {
		return month + "/" + day + "/" + year;
	}

	// convert to string, with dash
	private String toStringWithDash() {
		return month + "-" + day + "-" + year;
	}

	// convert to string, long form
	private String toStringLongForm() {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		// set up month name, day
		String s = months[month - 1] + " " + day;

		// add proper suffix to day
		if (day == 1 || day == 21 || day == 31) {
			s = s + "st";
		} else if (day == 2 || day == 22) {
			s = s + "nd";
		} else if (day == 3 || day == 23) {
			s = s + "rd";
		} else {
			s = s + "th";
		}

		// add year
		s = s + ", " + year;

		return s;
	}

	// set to print with slash
	public void setPrintWithSlash() {
		printFormat = 1;
	}

	// set to print with dash
	public void setPrintWithDash() {
		printFormat = 2;
	}

	// set to print in long form
	public void setPrintLongForm() {
		printFormat = 3;
	}

	// convert to String based on setting
	public String toString() {
		if (printFormat == 1) {
			return toStringWithSlash();
		} else if (printFormat == 2) {
			return toStringWithDash();
		} else {
			return toStringLongForm();
		}
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
