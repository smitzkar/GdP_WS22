public class Sieb {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        boolean[] p = new boolean[N];
        
        for (int i= 2; i<N; i++)
            p[i]= true; // initialization: no factors found yet

        for (int i= 2; i*i < N; i++) {
            if (p[i]) {
            // i is prime number -> leave p[i] == true
            // mark multiples of i as nonprime
                for (int n = 2; n*i<N; n++)
                p[n*i]= false;
            }
        }

        for (int i=2; i<N; i++)
            if (p[i])
                System.out.println(i+ " is prime");
    }

}
