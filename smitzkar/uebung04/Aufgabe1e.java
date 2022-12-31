public class Aufgabe1e {

	public static void main(String[] args) {
		int a = 123;
		System.out.println(magic2(magic1(magic2(magic1(a)))));
	}

	public static int[] magic1(int a) {
		int[] b = new int[a + "".length()];
		int i = 0;
		while (a > 0) {
			b[i++] = a % 10;
			a /= 10;
		}
		return b;
	}

	public static int magic2(int[] b) {
		int a = 0;
		for (int i = 0; i < b.length; i++) a += b[i];
		return a;
	}
}