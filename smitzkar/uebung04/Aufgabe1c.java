public class Aufgabe1c {

	public static void main(String[] args) {
		int[] a = { 7, 3, 5, 8, 2 };
		magic(a);
		for (int i = 0; i < a.length; i++) {
			if (i < a.length - 1) {
				System.out.print(a[i] + ", ");
				continue;
			}
			System.out.println(a[i]);
		}
	}

	public static int[] magic(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			a[i] = 2 * b[i];
		}
		return b;
	}
}