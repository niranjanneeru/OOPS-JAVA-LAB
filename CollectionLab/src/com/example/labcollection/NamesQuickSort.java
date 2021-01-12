package com.example.labcollection;

import java.util.ArrayList;
import java.util.Scanner;

public class NamesQuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Names to be sorted in a line with spaces");
        System.out.print("[INPUT] ");
        String domain = scanner.nextLine();
        ArrayList<String> names = splitNames(domain.split(" "));
        quickSort(names, 0, names.size() - 1);
        System.out.print("[SORTED] ");
        print(names);
    }

    private static void print(ArrayList<String> names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    private static void quickSort(ArrayList<String> names, int start, int end) {
        if (start < end) {
            int p = partition(names, start, end);
//            System.out.print("[DEBUG] ");
//            print(names);
            quickSort(names, start, p - 1);
            quickSort(names, p + 1, end);
        }
    }


    private static int partition(ArrayList<String> names, int start, int end) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (names.get(j).compareToIgnoreCase(names.get(end)) <= 0) {
                swap(names, i, j);
                i++;
            }
        }
        swap(names, i, end);
        return i;
    }

    private static void swap(ArrayList<String> names, int i, int j) {
        String name = names.get(i);
        names.set(i, names.get(j));
        names.set(j, name);
    }

    private static ArrayList<String> splitNames(String[] s) {
        ArrayList<String> names = new ArrayList<>();
        for (String name : s
        ) {
            if (!name.trim().equals("")) {
                names.add(name);
            }
        }
        return names;
    }
}
