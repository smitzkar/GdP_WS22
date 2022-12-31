public class ArmstrongNumbers {
	public static void main(String[] args) {

		int[] test = giveArmstrongNumbers(15);
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634
		printArray(test);

		System.out.println(isArmstrongNumber(231));
	}



	// TODO
	public static boolean isArmstrongNumber(int number) {

		// Deal with special case
		if (number == 0) return true;


		int digits = digits(number);	// Calls function to determine number of digits
		int sum = 0;					
		int numberCopy = number;		// Working copy
		int currentDigit;				// Not necessary, but improves readability

		// Iterates through all digits of the number, adding their value raised to power of digits.
		while (numberCopy != 0){
			currentDigit = numberCopy % 10; 			
			sum += Math.pow(currentDigit, digits); 
			numberCopy /= 10;
		}

		// Compares input number and calculated sum.
		return (number == sum);
	}

	// TODO
	public static int[] giveArmstrongNumbers(int n) {
		return new int[n];
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(i < a.length - 1 ? ", " : "\n");
		}
	}

	public static int digits(int number){
		// Determine number of digits for input number

		// Catch special case.
		if (number == 0) return 1;

		int digits = 0;

		// Interger divide input number by 10, count iterations until 0. 
		while (number != 0){
			number = number / 10;
			digits++;
		}
		return digits;
	}
}