package lab6;

import java.io.*;
import java.util.StringTokenizer;

public class InputOutput {


    public static void main(String[] args) {
        System.out.print("Enter number to add in a single line: ");
        BufferedReader bufferedReader = null;
        String nums = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            nums = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (nums != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(nums, " ", false);
            Integer sum = 0;
            System.out.println("The Entered Numbers are: ");
            while (stringTokenizer.hasMoreTokens()) {
                String num = stringTokenizer.nextToken();
                System.out.println(num);
                try {
                    sum = sum + Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    System.err.println("Number Format Exception: Accept numbers only :" + num);
                }
            }
            System.out.println("The sum of Numbers Entered:- " + sum);

        }
    }
}