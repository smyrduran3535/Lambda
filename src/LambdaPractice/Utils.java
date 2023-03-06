package LambdaPractice;

public class Utils {
    public static void main(String[] args) {
        yazMultiplyPrint(6);
    }

    public static void yazString(String s){
        System.out.println(s +" ");
    }
    public static void yazInteger(int s){
        System.out.println(s +" ");
    }
    public static int yazMultiply(int ...s){
            int multiply=1;
            for (int w : s ) {
                multiply =multiply *w;
            }
            return multiply;


    }
    public static void yazMultiplyPrint(int ...s){
        int multiply=1;
        for (int w : s ) {
            multiply =multiply *w;
            System.out.println(w);
        }



    }
}
