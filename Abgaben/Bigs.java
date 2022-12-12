public class Bigs {
	
	public static int[] removeLeadingZeroes(int [] input){

		// for optimisation, check if this is even necessary
		if (input[input.length - 1] != 0 || input.length == 1) return input;

		// checks how many leading Zeroes there are
		int leadingZeroes = 0;
		for (int i = 0; i < input.length; i++){
			if (input[input.length-1-i] == 0){
				leadingZeroes++;
			} else {
				break;
			}
		}

		// initiate new output array of proper size and copy everything up to (excluding) the leading Zeroes
		// should probably just call our copy method below? Would require some changes, though. Not worth it
		int [] output = new int [input.length - leadingZeroes];
		for (int i = 0; i < output.length; i++) {
			output[i] = input[i];
		}

		return output;

	}

	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b){

		// test which array is larger  
		int max = a.length; 
		if (max < b.length) max = b.length; 

		// instead of testing for various cases (a bit more difficult than expected), we just assume the worst case of needing a bigger array
		int [] output = new int [max+1]; 	

		int carry = 0;

		for (int i = 0; i < max; i++){

			// to avoid IndexOutOfBoundsException, store values into temp variables and set 0 if out of bounds
			int temp1, temp2;
			if (i >= a.length) temp1 = 0;
			else temp1 = a[i];
			if (i >= b.length) temp2 = 0;
			else temp2 = b[i];

			// add the numbers plus possible carry-over. if it's higher than 9, carry the 1
			int tempSum = temp1 + temp2 + carry;
			if (tempSum > 9){
				output[i] = tempSum % 10;
				carry = 1;
			} 
			else {
				output[i] = tempSum;
				carry = 0;
			}
		}

		// before returning, remove leading Zeroes 
		return removeLeadingZeroes(output);
	}
	
	
	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	static void print(int[ ] n){
		for(int i = 0; i < n.length; i++){
			System.out.print(n[n.length-1-i]);						// Integers are printed in the same line "backwards" form the array.
		}
		System.out.println();

		return;
	}
	
	// konstruiert ein einstelliges Ziffernfeld aus d
	static int[ ] digit(int d){
		int[] output = new int[1];
		if(d > 9 || d < 0){
			System.out.println("The  number is not a single digit integer");		// In case when someone wouldn't use a single digit input.
		} else {output[0] = d;}

		return output;
	}
 
	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[ ] Null(){
		int[] output = new int[1];
		output[0] = 0;

		return output;
	}
	
	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[ ] One(){
		int[] output = new int[1];
		output[0] = 1;
		
		return output;
	}

	// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
	static int mod10(int[ ] n){
		int output = n[0];												// number mod 10: The last digit of an input number.

		return output;
	}


	// ganzzahliger Quotient bei Division durch 10
	static int[ ] div10(int[ ] n){
		int[] output = new int[n.length-1];
		for(int i = 1; i < n.length; i++){
			output[i-1] = n[i];											// number div 10 (assuming it works like "int / int" ): The input number without the last number. 
		}																// Every number is moved to a place with an index - 1 with regard to index in input array 

		return output;
	}


	// Umwandlung einer int-Zahl in ein Ziffernfeld	
	static int[ ] fromInt(int n){ 
		String nString = String.valueOf(n);
		int[] output = new int[nString.length()];						// Length of output array is equal to length of the input number.

		for(int i = 0; i < output.length; i++){
			output[i] = n % 10;											// Similar algorithm to algorithm that inverts numbers from Palindrom-Aufgabe
			n = n / 10;													// To the index i in output array is assigned the last digit of input number.
		}																// The input number is divided by 10, since integers, we receive the input number
		return output;													// without the last digit. Than for-loop continues.
	}


	// kopiert den Wert von a
	static int[ ] copy(int[ ] n){
		int[] output = new int[n.length];

		for(int i = 0; i < n.length; i++){
			output[i] = n[i];											// Values from input array are assigned to the output array,
		}																// preserving the indexing structure.

		return output;
	}


	// multipliziert das Ziffernfeld a mit einer int-Zahl
	static int[ ] times(int[ ] n, int d){
		int[] output = new int[n.length+1];								// Assuming the worst case.

		/*
		 * Every digit from input array is multiplied by the digit d. Then we're correcting the numbers (>10) that are in output array 
		 * using modulo and div and adding the quotient to the place in array with an index enlarged by 1.
		 */

		for(int i = 0; i < n.length; i++){
			output[i] = n[i]*d;
		}
		for(int i = 0; i < output.length; i++){
			if(output[i] >= 10){
				output[i+1] = output[i+1] + output[i]/10;
				output[i] = output[i] % 10;
			}
		}
		
		return removeLeadingZeroes(output);								// Function that removes leading zeros from output.
	}


    // multipliziert das Ziffernfeld n mit 10
	static int[ ] times10(int[ ] n){ 
		int[] output = new int[n.length+1];
		for(int i = 0; i < n.length; i++){
			output[i+1] = n[i];											// Every number from input is assigned to the next place (index+1) in output array.
		}
		output[0] = 0;													// 0 is assigned to the first place in output array.

		return output;
	}
	

	// multipliziert zwei Ziffernfelder	
	static int[ ] times(int[ ]a, int[ ] b){
		int[] output = new int[a.length+b.length];						// Assuming the worst case.
		int[][] sumMatrix = new int[b.length][a.length+b.length];

		/*
		 * This algorithm works like column multiplication known primary school. The array "temp" is the whole array a multiplied by digit with index i from
		 * array b. Then "temp" is assigned to row of "sumMatrix" with index i and shifted by i. Since i is representing the index of digit i of b, we can use
		 * it as an indicator to determine which decimal place of number b it is. This allows us later to sum the columns of sumMartix, so that we get directly
		 * the output number, i.e. product of multiplication. Then we're correcting the numbers (>10) that are in output array using modulo and div and adding
		 * the quotient to the place in array with an index enlarged by 1.
		 */


		for(int i = 0; i < b.length; i++){
			int[] temp = times(a, b[i]);
			for(int j = 0; j < temp.length; j++){
				sumMatrix[i][j+i] = temp[j];
			}
		}
		for(int i = 0; i < a.length+b.length; i++){
			int sum = 0;
			for(int j = 0; j < b.length; j++){
				sum = sum + sumMatrix[j][i];
			}
			output[i] = sum;
		}
		for(int i = 0; i < output.length; i++){
			if(output[i] >= 10){
				output[i+1] = output[i+1] + output[i]/10;
				output[i] = output[i] % 10;
			}
		}

		return removeLeadingZeroes(output);								// Function that removes leading zeros from output.
	}
	

    // Quadratzahl eines Ziffernfeldes
	static int[ ] square(int[ ]a){
		int[] output = times(a, a);										// a^2 = a*a

		return output;
	}


    // Kubikzahl eines Ziffernfeldes
	static int[ ] cubic(int[ ]a){
		int[] output = times(square(a), a);								// a^3 = a^2*a

		return output;
	}

	
	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less(int[ ] a, int[ ] b) {

		// first check if one is bigger than the other (after removing potential leading zeroes)
		if (removeLeadingZeroes(a).length < removeLeadingZeroes(b).length) return true;

		// make sure they're not equal
		if (equal(a, b)) return false;

		// only if the easy checks above don't return a result, go through each value/position
		// start at the end as that's the highest decimal place
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] == b[i]) continue;
			if (a[i] < b[i]) return true;
			if (a[i] > b[i]) return false;
		}

		// IDE complains that it needs to return something. It should never get here, but if it does...
		return false;

	}


	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal(int[ ] a, int[ ] b){
		boolean output = false;
		int count = 0;
		
		/*
		 * Firstly we check if numbers have the same length. Then we're counting the equal pairs of numbers (with same indices) from both arrays a and b.
		 * If numbers have the same length and the number of counted pairs is equal to length of numbers, then these numbers are equal.
		 */

		if(a.length == b.length){
			for(int i = 0; i < a.length; i++){
				if(a[a.length-i-1] == b[b.length-i-1]){
					count++;
				}
			}
		}
		if(a.length == b.length && count == a.length){
			output = true;
		}
		return output;
	}

	/*
	Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
    mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
    keine fuehrenden Nullen (ausser bei Null selbst) 
	*/
	
	static boolean ok(int[ ] n){
		if(n.length == 0){
			return false;													// Number can't have length zero.
		}
		if(n[n.length-1] == 0 && n.length != 1){							// 0 can't be the first digit of a number unless it's 0 itself.
			return false;
		}
		for(int i = 0; i < n.length; i++){
			if(n[i] < 0 || n[i] > 9){										// Integers in array must be greater equal 0 and smaller equal 9.
				return false;
			}
		}
		
		return true;														// If nothing goes wrong, then the input number is okkk. 
	}
	

    // gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus	
	static void maxDigit(int[] n){
		int[] probArray = new int[10];

		/*
		 * Firstly we're counting the number of integers from 0 to 9 that are in the input array (their absolute frequencies).
		 * Then we're sorting this array of absolute frequencies and checking for which integer from 0 to 9 (counting from 0 to 9, so in case
		 * of equality it will be always the smaller integer) it's absolute frequency is equal to maximal (probArray[9]) absolute frequency.
		 * Lastly we're printing this integer.
		 */

		for(int i = 0; i < n.length; i++){
			for(int j = 0; j < 10; j++){
				if(n[i] == j){
					probArray[j]++;
				}
			}
		}
		int[] sortedArray = new int[10];
		for(int i = 0; i < 10; i++){
			sortedArray[i] = probArray[i];
		}
		int temp;

		for(int i = 0; i < 10; i++){
        	for(int j = i + 1; j < 10; j++){
                if(sortedArray[i] > sortedArray[j]){
                    temp = sortedArray[i];  
                    sortedArray[i] = sortedArray[j];  
                    sortedArray[j] = temp;  
                }
            }
        }
		for(int i = 0; i < 10; i++){
			if(probArray[i] == sortedArray[9]){
				System.out.println(i + ": " + sortedArray[9]);
				break;
			}
		}
	}

	public static void main (String[ ] s){
        int[] a = One();

		
		for (int i=0; i<33222; ++i) {
			a = times(a, 2);
		}
		
		System.out.println("2^33222 hat " + a.length + " Stellen");
		print(a); 
		System.out.println(); 

		
		int[] b = fromInt(13);
		int[] c = copy(b);
		
		for (int i=1; i<8978; ++i) {
			c=times(c, b);
		}
		
		System.out.println("13^8978 hat " + c.length + " Stellen");
		print(c); 
		System.out.println(); 
		
		System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
                maxDigit(a);
                maxDigit(c);

	}
}