package exceptions;

import java.io.*;

public class B {
    public static void main(String args[]) {
        try {
            String.txt = "new";
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String str = args[2];
            int x = Integer.parseInt(args[0]);
            FileInputStream in = new FileInputStream("input.txt");
            System.out.println("This is not printed");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: caused");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: caused");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: caused");
        }
    }
}
