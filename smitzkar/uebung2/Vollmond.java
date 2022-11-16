/* 
GdP - Uebungsblatt 2 - Aufgabe 1
Gruppe AG059
Autoren: ...
*/ 


public class Vollmond {

	// helper function to determine if leap year (taken from lecture notes)
	public static boolean isLeapYear(int year) {
		boolean leap;
		// divisible by 4 but not 100
		leap = (year % 4 == 0) && (year % 100 != 0);    
		// or divisible by 400
		leap = leap || (year % 400 == 0);	
		return leap;
	}


	// MAIN
	public static void main(String[] args) {

		int N = Integer.parseInt(args[0]);

		// variables to adjust the code (hopefully) without breaking it
		// IMPORTANT: Careful when messing with monthNames and monthDays as they aren't properly linked (can't have mixed arrays in java or we would have used a 2d array).
		int moonCycle = 29;
		int year = 2022;
		String monthNames [] = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
		int monthDays [] = {     31,       28,        31,      30,      31,    30,     31,     31,       30,          31,        30,         31};

		// counter variables
		int days = 1;
		int fullMoons = 0;
		int found = 0;

		// a bit of trickery to allow putting the year increments at start of while loop for easier readability
		year--; // 2021

		// Outer loop, each iteration equals a year
		while (found < N) {

			// at start of new year, increment variable. More logical to put it at the end, but easier to read this way
			year++; // 2022

			// call helper function, then adjust length of February stored in array
			boolean leapYear = isLeapYear(year);
			if (leapYear)
				monthDays[1] = 29;
			else 
				monthDays[1] = 28;

			
			// iterate through 12 months of the year
			for (int currentMonth = 0; currentMonth < (monthDays.length); currentMonth++) {

				// reset for new month
				fullMoons = 0;		

				// iterates over days of the current month, also increments global days counter!				
				for (int dayOfMonth = 1; dayOfMonth <= monthDays[currentMonth]; dayOfMonth++, days++) {

					// begin checking for full moons
					if (days % moonCycle == 1) 
						fullMoons++;
				}

				// at the end of each month, check if it had two full moons
				// if yes, print current year and month and increment found counter by 1
				if (fullMoons == 2) {
					System.out.println(year + ", " + monthNames[currentMonth]);
					found++;

					// because we only want EXACTLY N results and there might be two in a year, end loop early 
					if (found == N)
						break;
				}
			}
		}
	}
}