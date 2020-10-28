package com.example.labcollection;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Domain Array of Number: ");
        String domain = scanner.nextLine();
        System.out.print("Enter the Number to be Searched: ");
        int item = scanner.nextInt();
        int[] arr = convToIntArray(domain.split(" "));
        int start = 0;
        int end = arr.length - 1;
        int loc = recursive_search(arr, start, end, item);
        if (loc == -1) {
            System.out.println("Item Not Found");
        } else {
            System.out.println("Item Found at position :" + (loc + 1));
        }
    }

    private static int recursive_search(int[] arr, int start, int end, int item) {
        int middle = (start + end) / 2;
        if (start <= end && start >= 0 && end < arr.length) {
            if (arr[middle] == item) {
                return middle;
            } else if (arr[middle] < item) {
                return recursive_search(arr, middle + 1, end, item);
            } else if (arr[middle] > item) {
                return recursive_search(arr, start, middle - 1, item);
            }
        }
        return -1;
    }

    private static int[] convToIntArray(String[] domain) throws NumberFormatException {
        int[] arr = new int[domain.length];
        int i = 0;
        for (String d : domain) {
            arr[i++] = Integer.parseInt(d);
        }
        return arr;
    }
}
