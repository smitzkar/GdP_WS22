/* 
GdP - Uebungsblatt 2 - Aufgabe 1
Gruppe AG059
Autoren: ...
*/ 

// Gesucht: erste n Monate mit 2 Vollmonden (Mondzyklus 29 Tage)
// TODO  


class Vollmond {

// main - accepting 1 argument -> int n 
  public static void main(String[] args) {
  int N = Integer.parseInt(args[0]);




// initialise all needed variables in one place to more easily adapt program later

// procedure to determine if leap year (one solution in lecture notes)

// create array with months: Januar, Februar, Maerz, April, Mai, Juni, Juli, August, September, Oktober, November
// und Dezember
// and their corresponding lengths in days 
// (two dimensional array?)

  // dumbass java doesn't allow mixed arrays...
  // fuck

  // just do two arrays?  
  // this is some bs
  String MonthNames [] = {"Januar", "Februar", "Maerz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
  int MonthDays [] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  boolean leapYear = false;
  if (leapYear) 
    MonthDays[1] = 29;
  else 
    MonthDays[1] = 28;

  // check to see if both can be accessed
  int x = 10; // throwaway variable
  System.out.println("Der " + (x) + ". Monat ist " + MonthNames[x-1] + " und hat " + MonthDays[x-1] + " days.");



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