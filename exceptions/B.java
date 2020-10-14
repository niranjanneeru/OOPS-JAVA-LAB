package exceptions;

import java.io.*;

public class B {
    public static void main(String args[]) {
        try {
            String str = args[2];
            int x = Integer.parseInt(args[0]);
            FileInputStream in = new FileInputStream("input.txt");
            System.out.println("This is not printed");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException: " + e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
