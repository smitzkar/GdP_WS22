class Nolindrom {

// Function to return the reverse of an Input
    static long reverseInput(long N) {

		long R = 0;
		long temp = 0;
		boolean keepGoing = true;
		while (keepGoing) {
			temp = N % 10;
			N = N / 10;
			R = R * 10 + temp;

			// checks if there's anything left to work on
			if (N == 0) {
			keepGoing = false;
			continue;
			}
		}
		return R;
    }


	// MAIN
  	public static void main(String[] args) {
		long Input = Long.parseLong(args[0]);

		// Call function, then print the result for testing purposes
		long Reverse = reverseInput(Input);
		System.out.println(Reverse);

		// Check if sum == palyndrome  
		long Summe = Input + Reverse;
		long SummeR = reverseInput(Summe);
		if (Summe == SummeR) {
		System.out.println(Summe + " ist ein Palyndrom!");
		}



		// Actual big loop 
		// go through all numbers from 1 to (including) input
		for (int i = 1; i <= 300 i++) {
		
		// call algo until either palyndrome found or nothing after 100 iterations

		}

	}
}

