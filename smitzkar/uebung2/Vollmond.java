/* 
GdP - Uebungsblatt 2 - Aufgabe 1
Gruppe AG059
Autoren: ...
*/ 

// Gesucht: erste n Monate mit 2 Vollmonden (Mondzyklus 29 Tage)
// TODO  



class Vollmond {

	// function to determine if leap year (taken from lecture notes)
	public static boolean isLeapYear(int year) {
		boolean leap;
		// divisible by 4 but not 100
		leap = (year % 4 == 0) && (year % 100 != 0);    
		// or divisible by 400
		leap = leap || (year % 400 == 0);
		
		return leap;
	}


// main - accepting 1 argument -> int n 
	public static void main(String[] args) {

    	// Initialise variables
		int N = Integer.parseInt(args[0]);
		int year = 2022;
		// Not allowed to have mixed type arrays in java, so name and length of months has to be stored in 2 separate arrays. 
		// Seems somewhat sketchy, but they stay a constant length, so it should be ok. Added whitespace for legibility. 
		String monthNames [] = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
		int monthDays [] = {     31,       28,        31,      30,      31,    30,     31,     31,       30,          31,        30,         31};

		// Start of Year

		// call helper function, then adjust length of February stored in array
		boolean leapYear = isLeapYear(year);
		if (leapYear) 
		monthDays[1] = 29;
		else 
		monthDays[1] = 28;

    

		// check to see if both can be accessed
		int x = 10; // throwaway variable
		System.out.println("Der " + (x) + ". Monat ist " + monthNames[x-1] + " und hat " + monthDays[x-1] + " days.");



		// outer loop 
		// while (int found != n) ...

		// start of new year  
		// if leapyear Februar_length = 29 else Februar_length = 28 
		// year++



		// inner loop

		// for (months in monthsArray) ...
		//   // reset moon counter  
		//   moon = 0;

		//   for (int i = 0; i <= currentMonth_length; i++)
		//     if (days % 29 == 1) moon++
		//     if (moon == 2) printline (current year, month), found++ 

	}
}