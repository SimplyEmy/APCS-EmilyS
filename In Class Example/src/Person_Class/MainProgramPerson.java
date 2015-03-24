package Person_Class;

import java.util.*;

public class MainProgramPerson {

	public static void main(String[] args) {
		String printing;
		
		Person p = new Person();
		Student s = new Student();
		Teacher t = new Teacher();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Teacher/Student/Person First name: ");
		String first = scan.nextLine();
		
		p.setFirstName(first);
		
		System.out.println();
		System.out.print("Teacher/Student/Person Last name: ");
		String last = scan.nextLine();
		
		p.setLastName(last);
		
		System.out.println();
		System.out.print("Is this a teacher, student or person: ");
		String decision = scan.nextLine();
		
		if (decision.equals("teacher")){
			System.out.println();
			System.out.print("What is their department? ");
			String department = scan.nextLine();
			
			t.setDepartment(department);
			
			printing = "Department: " + t.getDepartment();
			
		}else if(decision.equals("student")){
			System.out.println();
			System.out.print("Students Graduation Year: ");
			String year = scan.nextLine();
			
			s.setGraduationYear(year);
			
			printing = "Graduation Year: "+ s.getGraduationYear();
			
		}else{
			printing = "";

		}
		
		System.out.println();
		System.out.println("Name: " + p.getFullName() + " " + printing);
		
		scan.close();
		
	}

}
