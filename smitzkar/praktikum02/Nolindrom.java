class Nolindrom {
  public static void main(String[] args) {
    // check if Palindrome  
    long N = 4321;
    long R = 0;
    long temp = 0;


    // janky workaround  
    // typecast N longo string, then use .length...

    String stringN = String.valueOf(N);
    int lengthN = stringN.length();
    System.out.println(lengthN);
    



    boolean keepGoing = true;
    while (keepGoing) {
      temp = N % 10;
      N = N / 10;

      // doesn't work if there's a 0 somewhere in the number
      if (temp == 0) {
        keepGoing = false;
        continue;
      }

      R = R * 10 + temp;



    }

    System.out.println(R);


  }
}

