package Old_Classes;

import java.util.Scanner;

public class AddressValidatorBeautified {
	public static final int zipCodeLength = 5;
	public static final int stateLength = 2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		print("Enter your address (Street Address, City, State, Zip):");
		String input = scanner.nextLine();
		scanner.close();

		boolean addressIsValid = true;

		// start by breaking up the street address into the four components
		String[] addressPieces = GetAddressPieces(input);
		
		if(addressPieces == null) {
			addressIsValid = false;
		}
		else {
			addressIsValid = ValidateAddressPieces(addressPieces);
		}
		
		if (addressIsValid) {
			print("The address is valid.");
		} else {
			print("The address is invalid.");
		}
	}
	
	// prints a message to the screen
	public static void print(String message) {
		System.out.println(message);
	}
	
	public static String[] GetAddressPieces(String address) {
		int startPosition = 0;
		int count = 0;
		
		String[] addressPieces = new String[4];
		
		while(count < 3) {
			int commaPosition = address.indexOf(", ", startPosition);
			
			if(commaPosition == -1) {
				print("The address must be separated by commas. Format: Street Address, City, State, Zip");
				return null;
			}
			
			addressPieces[count] = address.substring(startPosition, commaPosition);
			startPosition = commaPosition + 2;
			count++;
		}
		
		addressPieces[count] = address.substring(startPosition);
		
		return addressPieces;
	}
	
	public static boolean ValidateAddressPieces(String[] addressPieces) {
		String[] addressPartNames = {"street address", "city", "state", "zip code"};
		int[] lengthRestrictions = {-1, -1, stateLength, zipCodeLength};
		
		for(int pieceIndex = 0; pieceIndex < addressPieces.length; pieceIndex++) {
			String addressPiece = addressPieces[pieceIndex];
			String addressPartName = addressPartNames[pieceIndex];
			int lengthRestriction = lengthRestrictions[pieceIndex];
			
			int length = addressPiece.length();
			
			if (length == 0) {
				print("The " + addressPartName + " is missing.");
				return false;
			}
			else if (lengthRestriction != -1 && length != lengthRestriction){
				print("The " + addressPartName + " must be " + lengthRestriction + " characters long.");
			}
			else {
				if(pieceIndex == 0) {
					if(!IsValidStreetAddress(addressPiece)){
						return false;
					}
				} 
				else if (pieceIndex == 1) {
					if(!IsValidCity(addressPiece)){
						return false;
					}
				} 
				else if (pieceIndex == 2) {
					if(!IsValidState(addressPiece)){
						return false;
					}
				} 
				else if (pieceIndex == 3) {
					if(!IsValidZipCode(addressPiece)){
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public static boolean IsValidStreetAddress(String streetAddress) {
		for (int position = 0; position < streetAddress.length(); position++) {
			char currentCharacter = streetAddress.charAt(position);
				
			if (!(IsSpace(currentCharacter)
					|| IsPeriod(currentCharacter)
					|| IsNumber(currentCharacter)
					|| IsUpperCaseLetter(currentCharacter) 
					|| IsLowerCaseLetter(currentCharacter))) {
				print("The street address can only contain letters, numbers, spaces, and a period.");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean IsValidCity(String city) {
		for (int position = 0; position < city.length(); position++) {
			char currentCharacter = city.charAt(position);
			
			if (!(
					IsSpace(currentCharacter)
					|| IsUpperCaseLetter(currentCharacter) 
					|| IsLowerCaseLetter(currentCharacter))) {
				print("The city can only contain letters and spaces.");
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean IsValidState(String state) {
		if (!IsUpperCaseLetter(state.charAt(0)) || !IsUpperCaseLetter(state.charAt(1))) {
			print("The state abbreviation must be capitalized.");
			return false;
		}
		
		return true;
	}
	
	public static boolean IsValidZipCode(String zipCode) {
		for (int position = 0; position < zipCodeLength; position++) {
			char currentCharacter = zipCode.charAt(position);
			
			if (!IsNumber(currentCharacter)) {
				print("The zip code can only contain numbers.");
				return false;
			}
		}
		
		return true;
	}

	// ASCII 48-57 is 0-9
	public static boolean IsNumber(char character) {
		if(character >= 48 && character <= 57) {
			return true;
		}
		
		return false;
		
		// could also write this whole function as (and similarly, the ones below): 
		// return character >= 48 && character <= 57;
	}

	// ASCII 65-90 is A-Z
	public static boolean IsUpperCaseLetter(char character) {
		if(character >= 65 && character <= 90) {
			return true;
		}
		
		return false;
	}

	// ASCII 97-122 is a-z
	public static boolean IsLowerCaseLetter(char character) {
		if(character >= 97 && character <= 122) {
			return true;
		}
		
		return false;
	}

	// ASCII 32 is space
	public static boolean IsSpace(char character) {
		if(character == 32) {
			return true;
		}
		
		return false;
	}

	// ASCII 46 is .
	public static boolean IsPeriod(char character) {
		if(character == 46) {
			return true;
		}
		
		return false;
	}
}