class GGT {
    public static void main(String[] args) {
        // Read arguments into variables  
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // Exit on invalid arguments
        if ((a <= 0) || (b <= 0)) {
            System.out.println("nur positive ganze Zahlen als Argumente erlaubt");
            System.exit(-1);
        }
        // Optional, check if only two arguments
        // if (args.length != 2) {
        //     System.out.println("Only works with two numbers!\nTry again!");
        //     System.exit(-1);
        // }
        // How to check if parseable to integer?  

        // Init variables for euclidian alg
        int m = a;
        int n = b;  
        int r = 1;

        while (r != 0) {
            // Swap m and n if m < n, using temporary variable
            if (m < n) {
                int t;
                t = m;
                m = n;
                n = t;
            }

            // Steps 3 and 4
            r = m - n;
            m = n;
            n = r;
        }


        System.out.println(m);
    }
}