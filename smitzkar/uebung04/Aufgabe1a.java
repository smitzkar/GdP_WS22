public class Aufgabe1a {

	public static void main(String[] args) {
		int a = 7;
		int b = 7;
		magic(a, b);
		System.out.println("a = " + a + "; b = " + b);
	}

	public static void magic(int a, int b) {
		System.out.println("Hello");
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
			return;
		}
	}
}