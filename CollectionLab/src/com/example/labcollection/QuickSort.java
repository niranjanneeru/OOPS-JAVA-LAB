package com.example.labcollection;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Array to be sorted: ");
        String domain = scanner.nextLine();
        try {
            int[] arr = convToIntArray(domain.split(" "));
            quickSort(arr, 0, arr.length - 1);
            System.out.print("[SORTED ARRAY] ");
            print(arr);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Unknown Literal");
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int q = partition(arr, start, end);
            System.out.print("[DEBUG ARRAY] ");
            print(arr);
            quickSort(arr, start, q - 1);
            quickSort(arr, q + 1, end);
        }
    }


    private static int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] <= x) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int[] convToIntArray(String[] domain) throws NumberFormatException {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        for (String d : domain) {
            if (!d.trim().equals("")) {
                result.add(Integer.parseInt(d));
            }
        }
        int[] arr = new int[result.size()];
        for (Integer k : result) {
            arr[i++] = k;
        }
        return arr;
    }


}
