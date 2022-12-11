public class Bigs {

	public static int[] removeLeadingZeroes(int [] input){

		int leadingZeroes = 0;

		// checks how many leading Zeroes there are
		for (int i = input.length - 1; i >= 0; i--){
			if (input[i] == 0) leadingZeroes++;
		}

		// initiate new output array of proper size and only copy everything up to (excluding) the leading Zeroes
		int [] output = new int [input.length - leadingZeroes];
		for (int i = 0; i < output.length; i++) {
			output[i] = input[i];
		}

		return output;

	}

	//implement following methods 

	// addiert die Ziffernfelder a und b
	public static int[ ] add (int[ ] a, int[ ] b){

		// Idea: add index by index. remember 1 for next, if > 9
		// how to test beforehand if we need a bigger array? 
		// might be helpful to compare the two (using less()?) 
		// this one is a bit tricky 

		// test which array is larger  
		int max = a.length; 
		if (max < b.length) max = b.length; 

		// not quite perfect way to ensure that target array is big enough. Fails for 1 + 99. 
		// alternatively, always assume that it's gonna need a bigger one, then remove the leading 0 if necessary?

		if (a.length == b.length && a[a.length - 1] + b[b.length - 1] > 9) max++;

		int remember = 0;	// variable to remember if we got over 10
		int [] c = new int [max];

		for (int i = 0; i < max; i++){

			// to avoid IndexOutOfBoundsException, store values into temp variables and set 0 if out of bounds
			int temp1, temp2;
			if (i >= a.length) temp1 = 0;
			else temp1 = a[i];
			if (i >= b.length) temp2 = 0;
			else temp2 = b[i];

			int tempSum = temp1 + temp2 + remember;
			if (tempSum > 9){
				c[i] = tempSum % 10;
				remember = 1;
			} 
			else {
				c[i] = tempSum;
				remember = 0;
			}
		}

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

	//	// multipliziert das Ziffernfeld a mit einer int-Zahl
	//	static int[ ] times(int[ ] n, int d)     { /* TODO */ }
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
	//	static boolean less (int[ ] a, int[ ] b) { /* TODO */ }

		// Idea: for optimisation, compare length first -> only do the actual comparison if inconclusive

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
	//	static boolean ok (int[ ] n)             { /* TODO */ }
	//
	//	// gibt die (kleinste) Ziffer mit der groessten Haeufigkeit in n aus	
	//	static void maxDigit(int[] n)            { /* TODO */ }

	public static void main (String[ ] s) {


		// tests
		print(One());
		print(digit(2));
		print(Null());
		int [] test1 = {1,2,3};
		int [] test2 = {9,9};
		print(add(test1, test2));
		print(div10(test1));

		int [] test3 = {1,2,3,4,0,0};
		print(removeLeadingZeroes(test3));

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
