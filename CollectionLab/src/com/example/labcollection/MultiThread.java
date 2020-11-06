package com.example.labcollection;

import java.util.Random;

public class MultiThread {

    public static void main(String[] args) {

        NewThread t = new NewThread();

    }
}

class NewThread {
    Random random = new Random();
    int n;


    java.lang.Thread T1 = new java.lang.Thread(new Runnable() {
        public void  run() {
            for (int i = 0; i < 100; i++) {
                n = random.nextInt(100);
                System.out.println("Number:- " + n);
                if (n % 2 == 0) {
                    java.lang.Thread even = new java.lang.Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Square:- " + (n * n));
                        }
                    });
                    even.start();
                } else {
                    java.lang.Thread odd = new java.lang.Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Cube:- " + (n * n * n));
                        }
                    });
                    odd.start();

                }
                try {
                    java.lang.Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    public NewThread() {
        T1.start();

    }
}
