package com.example.labcollection;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class dllsimple {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Choose an Operation\n1.Add\n2.Delete\n3.Display\n4.Exit\n: ");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("Enter a Number to Add: ");
                    numbers.add(scanner.nextInt());
                    break;
                case 2:
                    try {
                        int n = numbers.remove();
                        System.out.println("Element Removed: " + n);
                    } catch (NoSuchElementException e) {
                        System.out.println("Empty Linked List");
                    }
                    break;
                case 3:
                    if (numbers.isEmpty()) {
                        System.out.println("Empty Linked List");
                    } else {
                        System.out.print("Numbers: ");
                        for (Integer number : numbers) {
                            System.out.print(number);
                            System.out.print(" ");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Exiting...");
                    flag = false;
                    break;
            }
        }
    }
}

//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 1
//        Enter a Number to Add: 22
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 1
//        Enter a Number to Add: 77
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 1
//        Enter a Number to Add: 867
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 1
//        Enter a Number to Add: 33
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 3
//        Numbers: 22 77 867 33
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 2
//        Element Removed: 22
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 2
//        Element Removed: 77
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 3
//        Numbers: 867 33
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 2
//        Element Removed: 867
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 1
//        Enter a Number to Add: 2
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 3
//        Numbers: 33 2
//        Choose an Operation
//        1.Add
//        2.Delete
//        3.Display
//        4.Exit
//        : 4
//        Exiting...