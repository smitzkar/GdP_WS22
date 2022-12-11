public class Bigs {

	public static int[] removeLeadingZeroes(int [] input){

		// for optimisation, check if this is even necessary
		if (input[input.length - 1] != 0) return input;

		// checks how many leading Zeroes there are
		int leadingZeroes = 0;
		for (int i = input.length - 1; i >= 0; i--){
			if (input[i] == 0) leadingZeroes++;
		}

		// initiate new output array of proper size and copy everything up to (excluding) the leading Zeroes
		// should probably just call our copy method below? Would require some changes, though. Not worth it
		int [] output = new int [input.length - leadingZeroes];
		for (int i = 0; i < output.length; i++) {
			output[i] = input[i];
		}

		return output;

	}

	//implement following methods 

	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b){

		// test which array is larger  
		int max = a.length; 
		if (max < b.length) max = b.length; 

		// instead of testing for various cases (a bit more difficult than expected), we just assume the worst case of needing a bigger array
		int [] c = new int [max+1]; 	

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
				c[i] = tempSum % 10;
				carry = 1;
			} 
			else {
				c[i] = tempSum;
				carry = 0;
			}
		}

		// before returning, remove potential leading Zeroes 
		// return removeLeadingZeroes(c);
		return c;
	}

	// gibt das Ziffernfeld n in lesbarer dezimaler Form aus
	static void print (int[ ] n){ 
		for (int i=n.length-1; i>=0; i--) {
			System.out.print(n[i]);
		}
		System.out.println();
	}

	// konstruiert ein einstelliges Ziffernfeld aus d
	static int[ ] digit(int d){

		int [] digit = {d};
		return digit;
	}

	// konstruiert das Ziffernfeld, welches den Wert Null repraesentiert
	static int[ ] Null(){

		int [] Null = {0};
		return Null;
	}

	// konstruiert das Ziffernfeld, welches den Wert Eins repraesentiert
	static int[ ] One(){

		int [] One = {1};
		return One;
	}

//		// Rest des Ziffernfeldes n bei Division durch 10 (eine int-Zahl!)
//		static int mod10(int[ ] n)               { /* TODO */ }

	
	// ganzzahliger Quotient bei Division durch 10
	static int[ ] div10(int[ ] n)            { 
		int[] result = new int[n.length-1];
		
		for (int i = 0; i < result.length; i++) {
			result[i] = n[i+1];
		}
		
		return result;
	}

		
	// Umwandlung einer int-Zahl in ein Ziffernfeld	
	static int[ ] fromInt(int n){ 

		int number = n;
		String snumber = "" + n; // number is saved in a string to evaluate its length 

		int[] array = new int [snumber.length()]; 

		for (int i=0; i<array.length; i++ ) {
			array [i]= number%10;
			number= number/10;
		}
		return array;
	}

	// kopiert den Wert von a
	static int[ ] copy(int[ ] n){ 
		int[] copy= new int[n.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i]=n[i];
		}
		return copy;
	}

	// multipliziert das Ziffernfeld a mit einer int-Zahl
	static int[ ] times(int[ ] n, int d){
		int[] longOutput = new int[n.length+1];
		int[] output = new int[longOutput.length];

		for(int i = 0; i < n.length; i++){
			longOutput[i] = n[i]*d;
		}
		for(int i = 0; i < longOutput.length; i++){
			if(longOutput[i] >= 10){
				longOutput[i+1] = longOutput[i+1] + longOutput[i]/10;
				longOutput[i] = longOutput[i] % 10;
			}
		}

		print(output);
		return removeLeadingZeroes(output);
	}


	//
	//	// multipliziert das Ziffernfeld n mit 10
	//	static int[ ] times10(int[ ] n)          { /* TODO */ }

		// Idea: relativ einfach. Neues array mit length+1, append(0)
	//
	//	// multipliziert zwei Ziffernfelder	
	//	static int[ ] times(int[ ]a, int[ ] b)   { /* TODO */ }
	//
	//	// Quadratzahl eines Ziffernfeldes
	//	static int[ ] square(int[ ]a)            { /* TODO */ }
	//
	//	// Kubikzahl eines Ziffernfeldes
	//	static int[ ] cubic(int[ ]a)             { /* TODO */ }
	//

	//	// Test auf kleiner-Relation zweier Ziffernfelder: a < b ?
	static boolean less (int[ ] a, int[ ] b) {

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

		

	//

	// Test auf Gleichheit zweier Ziffernfelder
	static boolean equal (int[ ] a, int[ ] b) { 

		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < b.length; i++) {
			if(a[i]!=b[i]) {
				return false;
			}
		}
		return true;
	}
	

	//	// Test auf Korrektheit eines Ziffernfeldes: Feld existiert und enthaelt
	//	// mindenstens eine Ziffer, alle Positionen liegen zwischen 0 und 9
	//	// keine fuehrenden Nullen (ausser bei Null selbst) 
	// static boolean ok (int[ ] n) {
		
	// }
	//
	//	// gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus	
	//	static void maxDigit(int[] n)            { /* TODO */ }

	public static void main (String[ ] s) {


		// tests
		int [] test1 = {1,2,3};
		int [] test2 = {9,9};
		print(add(test1, test2));

		print(div10(test1));

		int [] test3 = {1,2,3,4,0,0};
		print(add(test3, test1));

		print(test3);
		print(removeLeadingZeroes(test3));
		print(times(test2, 6));

		System.out.println(equal(test2, test2));

		//		int[] a = One();

		//		for (int i=0; i<33222; ++i) {
		//			a = times(a, 2);
		//		}
		//
		//		System.out.println("2^33222 hat " + a.length + " Stellen");
		//		print(a); 
		//		System.out.println(); 
		//
		//		int[] b = fromInt(13);
		//		int[] c = copy(b);
		//
		//		for (int i=1; i<8978; ++i) {
		//			c=times(c, b);
		//		}
		//
		//		System.out.println("13^8978 hat " + c.length + " Stellen");
		//		print(c); 
		//		System.out.println(); 
		//
		//		System.out.println(less(a, c)); // beantwortet die Frage aus der Aufgabenueberschrift
		//		maxDigit(a);
		//		maxDigit(c);
	}

}
