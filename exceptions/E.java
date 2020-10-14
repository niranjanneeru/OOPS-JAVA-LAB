package exceptions;

public class E{
    public static void main(String args[]) throws ArithmeticException,NumberFormatException,ArrayIndexOutOfBoundsException{
        int a = 20;
        int c = Integer.parseInt(args[0]);
        int d = a/c;
        System.out.println(d);
    }
}
