package Old_Classes;


public class MatrixPatterns {
	// program constants
	final static int matrixSize = 10;
	final static int cellWidth = 3;

	public static void main(String[] args) {
		int[][] a = new int[matrixSize][matrixSize];

		// print original
		printMatrix(a);
		System.out.println();

		// set horizontal, print
		horizontal(a);
		printMatrix(a);
		System.out.println();
		
		//set vertical, print
		vertical(a);
		printMatrix(a);
		System.out.println();
		
		//set blinds, print
		blinds(a);
		printMatrix(a);
		System.out.println();
		
		//set angle, print
		angle(a);
		printMatrix(a);
		System.out.println();
		
		//set diagonals, print
		diagonals(a);
		printMatrix(a);
		System.out.println();
		
	}
	// horizontal
	static void horizontal(int[][] a) {
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				a[i][j] = i;
			}
		}
	}

	// vertical
	static void vertical(int[][] a) {
		// write this method
		//0 1 2 - 9
		//0 1 2 - 9
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				a[j][i] = i;
			}
		}	
	}
	// blinds
	static void blinds(int[][] a) {
		// write this method
		//11
		//88
		for (int i = 0; i < matrixSize; i = i + 2) {
			
			for (int j = 0; j < matrixSize; j++) {
				
				a[i][j] = 11;
			}	
		}		
		for (int i = 1; i < matrixSize; i = i + 2) {
			
			for (int j = 0; j < matrixSize; j++) {
				
				a[i][j] = 88;
			}
		}	
	}
	// right angle
	static void angle(int[][] a) {
		// write this method
		//00
		//01
		//012
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				a[i][j] = i;
			}	
		}
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < i; j++) {
				a[i][j] = j;
			}
		}	
	}
	// diagonals
	static void diagonals(int[][] a) {
		// write this method
		//0 - 9
		//1-10
		//2-11
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				a[i][j] = (i + j);
			}	
		}
	}
	// print matrix
	static void printMatrix(int[][] a) {
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				String s = " " + a[i][j];
				while (s.length() < cellWidth)
					s = " " + s;
				System.out.print(s);
			}
			System.out.println();
		}
	}
}



