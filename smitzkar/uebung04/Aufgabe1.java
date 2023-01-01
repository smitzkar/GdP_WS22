public class Aufgabe1 {

	// Teilaufgabe a)
	public static boolean[] aufgabe_a(boolean ergebnisseAusgeben) {
		// Geben Sie hier bitte f�r jede Aussage an,
		// ob die Aussage richtig (true)
		// oder falsch (false) ist.
		boolean a = false; // Aussage A
		boolean b = true; // Aussage B
		boolean c = false; // Aussage C
		boolean d = false; // Aussage D
		boolean e = false; // Aussage E
		boolean f = true; // Aussage F

		// ab hier bitte nichts mehr �ndern
		boolean[] antworten = { a, b, c, d, e, f };
		if (ergebnisseAusgeben)
			print('a', antworten);
		return antworten;
	}

	// Teilaufgabe b)
	public static boolean[] aufgabe_b(boolean ergebnisseAusgeben) {
		// Geben Sie hier bitte f�r jede Aussage an,
		// ob die Aussage richtig (true)
		// oder falsch (false) ist.
		boolean a = false; // Aussage A
		boolean b = false; // Aussage B
		boolean c = true; // Aussage C
		boolean d = false; // Aussage D
		boolean e = true; // Aussage E
		boolean f = false; // Aussage F

		// ab hier bitte nichts mehr �ndern
		boolean[] antworten = { a, b, c, d, e, f };
		if (ergebnisseAusgeben)
			print('b', antworten);
		return antworten;
	}

	// Teilaufgabe c)
	public static boolean[] aufgabe_c(boolean ergebnisseAusgeben) {
		// Geben Sie hier bitte f�r jede Aussage an,
		// ob die Aussage richtig (true)
		// oder falsch (false) ist.
		boolean a = false; // Aussage A
		boolean b = true; // Aussage B
		boolean c = false; // Aussage C
		boolean d = true; // Aussage D
		boolean e = true; // Aussage E
		boolean f = false; // Aussage F

		// ab hier bitte nichts mehr �ndern
		boolean[] antworten = { a, b, c, d, e, f };
		if (ergebnisseAusgeben)
			print('c', antworten);
		return antworten;
	}

	// Teilaufgabe a)
	public static boolean[] aufgabe_d(boolean ergebnisseAusgeben) {
		// Geben Sie hier bitte f�r jede Aussage an,
		// ob die Aussage richtig (true)
		// oder falsch (false) ist.
		boolean a = false; // Aussage A
		boolean b = false; // Aussage B
		boolean c = true; // Aussage C
		boolean d = true; // Aussage D
		boolean e = false; // Aussage E
		boolean f = true; // Aussage F

		// ab hier bitte nichts mehr �ndern
		boolean[] antworten = { a, b, c, d, e, f };
		if (ergebnisseAusgeben)
			print('d', antworten);
		return antworten;
	}

	// Teilaufgabe a)
	public static boolean[] aufgabe_e(boolean ergebnisseAusgeben) {
		// Geben Sie hier bitte f�r jede Aussage an,
		// ob die Aussage richtig (true)
		// oder falsch (false) ist.
		boolean a = false; // Aussage A
		boolean b = true; // Aussage B
		boolean c = true; // Aussage C
		boolean d = false; // Aussage D
		boolean e = false; // Aussage E
		boolean f = true; // Aussage F

		// ab hier bitte nichts mehr �ndern
		boolean[] antworten = { a, b, c, d, e, f };
		if (ergebnisseAusgeben)
			print('e', antworten);
		return antworten;
	}

	// Ausgabe der gew�hlten Antworten
	private static void print(char c, boolean[] b) {
		System.out.println("Teilaufgabe " + c + ")");
		for (int i = 0; i < b.length; i++) {
			System.out.print("Aussage " + (char) (65 + i) + " ist ");
			System.out.println(b[i] ? "richtig." : "falsch.");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("Unsere Antwortm�glichkeiten f�r Aufgabe 1\n");
		aufgabe_a(true);
		aufgabe_b(true);
		aufgabe_c(true);
		aufgabe_d(true);
		aufgabe_e(true);
	}
}