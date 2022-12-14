public class ArmstrongNumbers {
	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		printArray(giveArmstrongNumbers(n));

	}


	public static boolean isArmstrongNumber(int number) {

		int digits = numberOfDigits(number);	// Call function to determine number of digits
		int sum = 0;					
		int numberCopy = number;		// Working copy
		int currentDigit;			// Not necessary, but improves readability

		// Iterate through all digits of the number, adding their value raised to power of digits.
		// Use a do-while loop to most comfortably include 0.
		do {
			currentDigit = numberCopy % 10; 			
			sum += Math.pow(currentDigit, digits); 
			numberCopy /= 10;
		}
		while (numberCopy != 0);

		// Compare input number and calculated sum.
		return (number == sum);
	}

	public static int[] giveArmstrongNumbers(int n) {

		// Generate empty array to be filled with found Armstrong numbers
		int [] ArmstrongNumbers = new int [n];

		// Iterate through natural numbers until array is filled
		for (int i = 0, found = 0; found < n; i++){
			if (isArmstrongNumber(i)){
				ArmstrongNumbers[found] = i;
				found++;
			}
		}

		return ArmstrongNumbers;
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(i < a.length - 1 ? ", " : "\n");
		}
	}

	public static int numberOfDigits(int number){

		int digits = 0;

		// Interger-divide input number by 10 to remove last digit until none left. Count iterations.
		// Use do-while to include single digit numbers.
		do {
			number = number / 10;
			digits++;
		}
		while (number != 0);

		return digits;
	}
}

