class Nolindrom {

  //
  static long reverseInput(long N) {

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

    return R;


  }


  // MAIN
  public static void main(String[] args) {

    long Input = 123; // TODO get from args

    long R = reverseInput(Input);
    System.out.println(R);



  }
}

