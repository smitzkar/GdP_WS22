public class Aufgabe1b {

	public static void main(String[] args) {
		int[] a = { 7, 3};
		magic(a);
		System.out.println("a[0] = " + a[0] + "; a[1] = " + a[1]);
	}

	public static void magic(int[] a) {
		a[0] = a[1] - a[0];
		a[1] = a[1] - a[0];
		a[0] = a[1] + a[0];
	}
}