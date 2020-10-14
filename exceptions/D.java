package exceptions;

public class D {
    public static void main(String args[]) {
        if (args.length != 2) {
            throw new ArithmeticException("Enter 2 Numbers for addition");
        } else {
            try {
                int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
                System.out.println("Sum = " + sum);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
}
