class Nolindrom {
  public static void main(String[] args) {
    // check if Palindrome  
    long N = 40321;
    long R = 0;
    long temp = 0;


    boolean keepGoing = true;
    while (keepGoing) {
      temp = N % 10;
      N = N / 10;
      R = R * 10 + temp;

      // checks if there's anything left to work on
      if (N == 0) {
        keepGoing = false;
        continue;
      }
    }



    System.out.println(R);


  }
}

