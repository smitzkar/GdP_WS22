public class Roman {
    static String roman(int n) {
        return "Hey";
    }

    public static void main(String[] args) {

        // Behandlung fehlender oder falscher Eingabeparameter
        try{
            Integer.parseInt(args[0]);
          }
        catch(NumberFormatException e){
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            return;
          }

        if (args.length != 1) {
            System.out.println("Bitte eine Zahl als Parameter angeben.");
            return;
        }

        int N = Integer.parseInt(args[0]);
        if (1 >= N && N >= 5000) {
            System.out.println("Die Zahl muss zwischen 1 und 5000 liegen.");
            return;
        }
          
        assert (1 <= N && N <= 5000);
        System.out.println(roman(N));

        return;
    }
    
}
