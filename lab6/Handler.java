package lab6;

import java.io.*;

public class Handler {


    public static void main(String[] args) {
        String file = "sample.txt";
        if (args.length == 0) {
            try {
                write("This is Java", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                write(String.join(" ", args), file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nRead...\n");
        try {
            System.out.println(read(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String text, String file) throws IOException {
        BufferedOutputStream bufferedWriter = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(file);
        bufferedWriter = new BufferedOutputStream(fileWriter);
        bufferedWriter.write(text.getBytes());
        bufferedWriter.flush();
        if (fileWriter != null) {
            fileWriter.close();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        System.out.println("Successfully Added \"" + text + "\" into the file : " + file);
    }

    public static String read(String file) throws IOException {
        BufferedInputStream bufferedReader = null;
        FileInputStream fileReader = null;
        fileReader = new FileInputStream(file);
        bufferedReader = new BufferedInputStream(fileReader);
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        while ((i = bufferedReader.read()) != -1) {
            stringBuilder.append((char) i);
        }
        if (fileReader != null) {
            fileReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return stringBuilder.toString();
    }
}