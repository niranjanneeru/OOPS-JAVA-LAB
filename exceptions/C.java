package exceptions;

import java.io.*;

public class C {
    public static void main(String args[]) {
        try {
            String str = args[2];
            try {
                int x = Integer.parseInt(args[0]);
                System.out.println("The Number "+x);
                try {
                    FileInputStream in = new FileInputStream("input.txt");
                    System.out.println("This is not printed");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                System.err.println("NumberFormatException: " + e.getMessage());
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
