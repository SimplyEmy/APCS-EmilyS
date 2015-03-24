package Old_Classes;


public class Cents {

	public static void main(String[] args) {
		
		int q=25;
		int n=10;
		int d=5;
		int p=1;
		
		// q= quarters, n= nickels, d=dimes, p=pennies
		
		int qq=90/q;
		int nn=qq/n;
		int dd=nn/d;
		int pp=dd/p;
		
		int T=90-qq-nn-dd-pp;
		
		System.out.println("Test: " + T); 

	}

}
