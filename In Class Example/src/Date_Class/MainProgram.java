package Date_Class;
//Seattle Prep CS class
//12/14/2014
public class MainProgram {

	// client for Date class
	public static void main(String[] args) {
		// create a date, show the two string formats
		Date d1 = new Date(12, 14, 2014);
		System.out.println("Two string formats: " + d1.toStringWithDash()
+ " " + d1.toStringWithSlash() + " " + d1.toStringWithFullDate());

		// create date, set print format and use toString
		Date d2 = new Date(12, 24, 2014);
		d2.setPrintWithDash();
		System.out.println("String after setPrintWithDash: " + d2.toString());
		d2.setPrintWithSlash();
		System.out.println("String after setPrintWithSlash: " + d2.toString());
		d2.setPrintWithFullDate();
		System.out.println("String after setPrintWithFullDate: " + d2.toString());

		// create date, set print format and use System.out.println directly on
		// object
		Date d3 = new Date(1, 1, 2015);
		d3.setPrintWithDash();
		System.out.println("Implicit use of toString: " + d3);
		d3.setPrintWithSlash();
		System.out.println("Implicit use of toString: " + d3);
		d3.setPrintWithFullDate();
		System.out.println("Implicit use of toString: " + d3);
		
		
	}

}
