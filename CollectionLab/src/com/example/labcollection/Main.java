package com.example.labcollection;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentLinkedList students = new StudentLinkedList();
        boolean flag = true;
        while (flag) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    students.add(acceptStudent());
                    break;
                case 2:
                    if (delete(students)) {
                        System.out.println("Successful Operation");
                    } else {
                        System.out.println("Failed to Delete");
                    }
                    break;
                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No Details Available");
                    } else {
                        System.out.println("Details: ");
                        for (Student student : students) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 4:

                    if (students.addAllWithId()) {
                        System.out.println("List Duplicated");
                    }
                    break;
                case 5:
                    students.clear();
                    System.out.println("Successfully Cleared");
                    break;
                case 6:
                    System.out.print("Enter the number of Test Data: ");
                    int val = scanner.nextInt();
                    for (int i = 0; i < val; i++) {
                        students.add(new Student("User " + i));
                        System.out.println("Added User " + i);
                    }
                    break;
                default:
                    System.out.println("Exiting...");
                    flag = false;
                    break;
            }
        }
    }

    private static boolean delete(LinkedList<Student> students) {
        System.out.println("Delete\n1.By Id\n2.By Name\n3.Menu");
        switch (scanner.nextInt()) {
            case 1:
                System.out.print("Enter Id: ");
                int val = scanner.nextInt();
                for (Student student : students) {
                    if (student.getId() == val) {
                        return students.remove(student);
                    }
                }
                return false;
            case 2:
                System.out.print("Enter Name: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                for (Student student : students) {
                    if (student.getName().equals(name)) {
                        return students.remove(student);
                    }
                }
                return false;
            default:
                return false;
        }
    }

    private static Student acceptStudent() {
        System.out.println("Let's add a new Student to DLL");
        System.out.print("Enter Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        Student student = new Student(name);
        System.out.println("Added in " + student);
        return student;
    }

    private static void menu() {
        System.out.print("Choose an Operation\n1.Add\n2.Delete\n3.Display\n4.Duplicate\n5.Clear \n6.Add Test Data \n7.Exit\n: ");
    }
}
