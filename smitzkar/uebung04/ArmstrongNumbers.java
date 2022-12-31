public class ArmstrongNumbers {
	public static void main(String[] args) {
		int[] test = giveArmstrongNumbers(15);
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634
		printArray(test);

		System.out.println(digits(20));
	}

	public static int digits(int number){
		// Determine number of digits for input number
		int digits = 0;
		while (number != 0){
			number = number / 10;
			digits++;
		}
		return digits;
	}

	public static boolean isArmstrongNumber(int number) {
		return false;
	}

	public static int[] giveArmstrongNumbers(int n) {
		return new int[n];
	}

	private static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			System.out.print(i < a.length - 1 ? ", " : "\n");
		}
	}
}