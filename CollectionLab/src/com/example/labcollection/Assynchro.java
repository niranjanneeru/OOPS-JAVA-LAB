package com.example.labcollection;

public class Assynchro {
    Runnable randWork = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 12; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            new Thread(work).start();
        }
    };


    Runnable work = new Runnable() {
        @Override
        public synchronized void run() {
            System.out.println("Synchronized");
            for (int i = 0; i < 12; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Assynchro() {
        System.out.println("Non - Synchronized");

        new Thread(randWork).start();
        new Thread(randWork).start();
    }

    public static void main(String[] args) {
        new Assynchro();
    }
}
