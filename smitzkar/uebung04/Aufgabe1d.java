public class Aufgabe1d {

	public static void main(String[] args) {
		int a = 1;
		int[] b = { 7, 3, 5 };
		b = magic(a, b);
		for (int i : b) System.out.print(i + ", ");
	}

	public static int[] magic(int a, int[] b) {
		int[] c = new int[a * b.length];
		for (int i = 0; i < c.length; i++) c[i] = b[i % a];
		return c;
	}
}