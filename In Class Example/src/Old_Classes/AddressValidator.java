package Old_Classes;


import java.util.Scanner;

public class AddressValidator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out
				.println("Enter your address (Street Address, City, State, Zip):");
		String input = scanner.nextLine();
		scanner.close();

		boolean addressIsValid = true;

		// start by breaking up the street address into the four components
		int firstComma = input.indexOf(", ");
		if (firstComma == -1) {
			System.out
					.println("The address must be separated by commas. Format: Street Address, City, State, Zip");
			addressIsValid = false;
		} else {
			String streetAddress = input.substring(0, firstComma);

			int secondComma = input.indexOf(", ", firstComma + 2);
			if (secondComma == -1) {
				System.out
						.println("The address must be separated by commas. Format: Street Address, City, State, Zip");
				addressIsValid = false;
			} else {
				String city = input.substring(firstComma + 2, secondComma);

				int thirdComma = input.indexOf(", ", secondComma + 2);

				if (thirdComma == -1) {
					System.out.println("The address must be separated by commas. Format: Street Address, City, State, Zip");
					addressIsValid = false;
				} else {
					String state = input.substring(secondComma + 2, thirdComma);
					String zipCode = input.substring(thirdComma + 2);

					// validate street address
				
					// ASCII 32 is space
					// ASCII 46 is .
					// ASCII 48-57 is 0-9
					// ASCII 65-90 is A-Z
					// ASCII 97-122 is a-z

					if (streetAddress.length() == 0) {
						System.out.println("The street address is missing.");
						addressIsValid = false;
					} else {

						for (int position = 0; position < streetAddress
								.length(); position++) {

							if (!(streetAddress.charAt(position) == 32
									|| streetAddress.charAt(position) == 46
									|| (streetAddress.charAt(position) >= 48 && streetAddress
											.charAt(position) <= 57)
									|| (streetAddress.charAt(position) >= 65 && streetAddress
											.charAt(position) <= 90) || (streetAddress
									.charAt(position) >= 97 && streetAddress
									.charAt(position) <= 122))) {
								System.out
										.println("The street address can only contain letters, numbers, spaces, and a period.");
								addressIsValid = false;
							}
						}
					}

					// validate city
					if (city.length() == 0) {
						System.out.println("The city is missing.");
						addressIsValid = false;
					} else {
						for (int position = 0; position < city.length(); position++) {
							if (!(city.charAt(position) == 32
									|| (city.charAt(position) >= 65 && city
											.charAt(position) <= 90) || (city
									.charAt(position) >= 97 && city
									.charAt(position) <= 122))) {
								System.out
										.println("The city can only contain letters and spaces.");
								addressIsValid = false;
							}
						}
					}

					// validate state
					if (state.length() == 0) {
						System.out.println("The state is missing.");
						addressIsValid = false;
					} else {
						if (state.length() != 2) {
							System.out
									.println("The state must be a two-letter abbreviation.");
							addressIsValid = false;
						} else {
							if (!(state.charAt(0) >= 65 && state.charAt(0) <= 90)) {
								System.out
										.println("The state abbreviation must be capitalized.");
								addressIsValid = false;
							} else if (!(state.charAt(1) >= 65 && state
									.charAt(1) <= 90)) {
								System.out
										.println("The state abbreviation must be capitalized.");
								addressIsValid = false;
							}
						}
					}

					// validate zip code
					if (zipCode.length() == 0) {
						System.out.println("The zip code is missing.");
						addressIsValid = false;
					} else {
						if (zipCode.length() != 5) {
							System.out
									.println("The zip code must be 5 digits.");
							addressIsValid = false;
						} else {
							for (int position = 0; position < 5; position++) {
								if (!(zipCode.charAt(position) >= 48 && zipCode
										.charAt(position) <= 57)) {
									System.out
											.println("The zip code can only contain numbers.");
									addressIsValid = false;
								}
							}
						}
					}
				}
			}
		}

		if (addressIsValid) {
			System.out.println("The address is valid.");
		} else {
			System.out.println("The address is invalid.");
		}
		
	}
	
		
	
}
