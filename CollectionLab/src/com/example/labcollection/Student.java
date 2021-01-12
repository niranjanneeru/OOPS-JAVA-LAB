package com.example.labcollection;

public class Student {
    private static int total = 0;
    private int id;
    private String name;

    public Student(String name) {
//        this();
        this.name = name;
    }

//    public Student() {
//        this.id = ++total;
//    }

    public static int getTotal() {
        return total;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setTotal(int total) {
        Student.total = total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        new Student("Hello");
    }
}
