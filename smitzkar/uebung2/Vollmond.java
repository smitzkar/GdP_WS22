/* 
GdP - Uebungsblatt 2 - Aufgabe 1
Gruppe AG059
Autoren: ...
*/ 


public class Vollmond {

	// function to determine if leap year (taken from lecture notes)
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
		int found = 0;
		int moonCycle = 29;
		int fullMoons;
		int days = 1; // here?
		int year = 2022;
		// Not allowed to have mixed type arrays in java, so name and length of months has to be stored in 2 separate arrays. 
		// Seems somewhat sketchy, but they stay a constant length, so it should be ok. Added whitespace for legibility. 
		String monthNames [] = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
		int monthDays [] = {     31,       28,        31,      30,      31,    30,     31,     31,       30,          31,        30,         31};

		// a bit of trickery to allow putting the year increments at start of while loop for easier readability
		year--;  

		// Outer loop, each iteration equals a year
		while (found < N) {

			// at start of new year, increment variable. More logical to put it at the end, but easier to read this way
			year++;

			// call helper function, then adjust length of February stored in array
			boolean leapYear = isLeapYear(year);
			if (leapYear) 
			monthDays[1] = 29;
			else 
			monthDays[1] = 28;

			
			// iterate through 12 months of the year
			for (int currentMonth = 0; currentMonth <= (monthDays.length - 1); currentMonth++) {

				// reset to 0 for new month
				fullMoons = 0;
				
				// System.out.println(monthNames[currentMonth]);
				// System.out.println(monthDays[currentMonth]);
				

				// iterates over days of the current month, also increments global days counter				
				for (int dayOfMonth = 1; dayOfMonth <= monthDays[currentMonth]; dayOfMonth++, days++) {

					// begin checking for full moons
					if (days % moonCycle == 1) 
						fullMoons++;

					// System.out.println(fullMoons);
					// System.out.println(days);
				}

				// at the end of each month, check if it had two full moons
				// if yes, print current year and month and increment found counter by 1
				if (fullMoons == 2) {
					System.out.println(year + ", " + monthNames[currentMonth]);
					found++;

					// because we ONLY want N results and there might be two in a year, end loop early 
					// (technically unnecessary, but good to have if adjusting program later on)
					if (found == N)
						continue;
				}
			}
		

		}


		// inner loop

		// for (months in monthsArray) ...
		//   // reset moon counter  
		//   moon = 0;

		//   for (int i = 0; i <= currentMonth_length; i++)
		//     if (days % 29 == 1) moon++
		//     if (moon == 2) printline (current year, month), found++ 

	}
}