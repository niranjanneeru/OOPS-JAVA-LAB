package com.example.labcollection;

import java.util.Scanner;

public class binsearchsimple {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of elements: ");
        int total = scanner.nextInt();
        int[] arr = new int[total];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < total; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter the element to be found: ");
        int f = scanner.nextInt(); // Element to be found
        int s = 0; // start
        int l = arr.length - 1; //last
        int pos = recursive(arr, s, l, f);
        if (pos == -1) {
            System.out.println("Element Not Found");
        } else {
            System.out.println("Element Found at position :" + (pos + 1));
        }
    }

    private static int recursive(int[] array, int initial, int last, int element) {
        int m = (initial + last) / 2; // middle
        if (initial <= last) {
            if (array[m] < element) {
                return recursive(array, m + 1, last, element);
            } else if (array[m] > element) {
                return recursive(array, initial, m - 1, element);
            } else if (array[m] == element) {
                return m;
            }
        }
        return -1;
    }
}


//        Enter the number of elements: 5
//        Enter the elements: 1 2 3 4 5
//        Enter the element to be found: 3
//        Element Found at position :3
//
//        Enter the number of elements: 5
//        Enter the elements: 1 2 3 4 5
//        Enter the element to be found: 1
//        Element Found at position :1
//
//        Enter the number of elements: 5
//        Enter the elements: 1 2 3 4 5
//        Enter the element to be found: 5
//        Element Found at position :5
//
//        Enter the number of elements: 5
//        Enter the elements: 1 2 3 4 5
//        Enter the element to be found: 7
//        Element Not Found