/* 
GdP - Uebungsblatt 2 - Aufgabe 1
Gruppe AG059
Autoren: ...
*/ 


public class VollmondX {

	// helper function to determine if leap year
	public static boolean isLeapYear(int year) {
		boolean leapYear;
		if (year % 4 != 0)
			leapYear = false;
		else if (year % 100 != 0)
			leapYear = true;
		else if (year % 400 != 0)
			leapYear = false;
		else 
			leapYear = true;
		
		return leapYear;
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
		
		// for optional functionality at the end. should probably have been generated programmatically
		int monthDistribution [] = {0,0,0,0,0,0,0,0,0,0,0,0};
		int yearDistribution [] = {0,0}; 
		// end of optional

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

			
			// iterates through 12 months of the year
			for (int currentMonth = 0; currentMonth < (monthDays.length); currentMonth++) {

				// reset for new month
				fullMoons = 0;		

				// iterates over days of the current month, also increments global days counter!				
				for (int dayOfMonth = 1; dayOfMonth <= monthDays[currentMonth]; dayOfMonth++, days++) {

					// for every day of the month, it checks if it is a full moon
					if (days % moonCycle == 1) 
						fullMoons++;
				}

				// at the end of each month, check if it had two full moons
				// if yes, print current year and month and increment found counter by 1
				if (fullMoons == 2) {
					System.out.println(year + ", " + monthNames[currentMonth]);
					found++;

					// optional
					monthDistribution[currentMonth]++;  
					if (leapYear)
						yearDistribution[1]++;
					else 
						yearDistribution[0]++;
					// end of optional

					// because we only want EXACTLY N results, end loop early 
					if (found == N)
						break;
				}
			}
		}


		/******************************************************************************
			Optional FUNctionality
		******************************************************************************/
		/* when running the program for high Ns, it would be interesting to see the distribution of double full moons 
		over the months of the year. To allow for this tracking, we added two more arrays (should really be using class 
		or objects or custom data types for this) and a simple statement in our `if (fullMoons == 2)` condition check.
		*/ 

		// to enable, disable. If false, the return statement ends the program before reaching the analytics 
		boolean runAnalytics = false;
		if (!runAnalytics)
			return;


		// using a for-each loop here, just for the sake of trying it. Variation between `print` and `println` for 
		// proper formatting
		System.out.println("---ANALYTICS---\nMonths with double full moons:");
		System.out.print("[");
		int i = 0;
		for (int month : monthDistribution) {
			System.out.print(monthNames[i] + ": " + month + ", "); // formatting isn't quite right, but good enough!
			i++;
		}
		System.out.println("]");

		// also interesting: how does it look for leap vs normal years?
		// as before, added a small counter to fullMoons check
		System.out.println("Months with double full moons in:");
		System.out.println("Regular years: " + yearDistribution[0]);
		System.out.println("Leap years: " + yearDistribution[1]);

		/*		
		Results for N = 1,000,000

		Months with double full moons:
			[Januar: 111113, 
			Februar: 0, 
			Maerz: 111113, 
			April: 55554, 
			Mai: 111110, 
			Juni: 55558, 
			Juli: 111111, 
			August: 111109, 
			September: 55556, 
			Oktober: 111112, 
			November: 55556, 
			Dezember: 111108]
		=> remarkably even! 

		Might be interesting to see if there's a pattern. 
		Just from a quick look, there seems to be some rhyme to it:
			  1613078, April
			1613079, Dezember
			 1613081, August
			  1613083, Mai
			1613084, Dezember
			 1613086, August
			  1613088, Mai
			1613089, Dezember
			 1613091, September
			  1613093, Mai
			1613095, Januar

		less obvious, but still noticable here:
			1612958, Oktober
			 1612960, Juli
			  1612962, Maerz
			1612963, November
			 1612965, Juli
			  1612967, April
			1612968, November
			 1612970, August
			  1612972, April
			1612973, Dezember

		Months with double full moons in:
			Regular years: 757500
			Leap years: 242500
		=> a slight bias for regular years
			
		First: 	Januar, 2022
		Last: 	Juni, 	1613130
		=> It took 1,611,108 years to reach 1,000,000 hits

		*/

	}
}
