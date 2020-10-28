package com.example.labcollection;

import java.util.LinkedList;

public class StudentLinkedList extends LinkedList<Student> {

    public boolean addAllWithId() {
        StudentLinkedList duplicates = new StudentLinkedList();
        for (Student student : this) {
            Student next = new Student(student.getName());
            duplicates.add(next);
            System.out.println("Adding "+next);
        }
        return super.addAll(duplicates);
    }
}
