public class Sieb {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        boolean[] p = new boolean[N];

        // Problem: how to figure out how big of an array is required?  
        // Idea: run the loop in "chunks" of numbers until enough primes found  
        // Possile complications: can java arrays be appended after init? -> nope
        // Solution: create new arrays? Seems wasteful
        
        // Initialise array with all values true
        for (int i= 2; i<N; i++)
            p[i]= true;

        // Go through array and switch to false if not a prime
        for (int i= 2; i*i < N; i++) {
            if (p[i]) {
                for (int n = 2; n*i<N; n++)
                    p[n*i]= false;
            }
        }

        for (int i=2; i<N; i++)
            if (p[i])
                System.out.println(i);
    }

}
