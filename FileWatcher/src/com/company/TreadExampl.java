package com.company;

import java.util.ArrayList;

public class TreadExampl {
    public ArrayList filearrayyy;
    public ArrayList filesarrayyy2;
    public long inter;

    Runnable r = new Runnable() {
        @Override
        public void run() {

        }
    };




    public void p1() {
        for (int i =0 ; i < 1000; i++) {
            synchronized (this.r) {
                if (filearrayyy.hashCode() == filesarrayyy2.hashCode()) {
                    i++;

                }
                filearrayyy = filesarrayyy2;

                System.out.println("Папка изменена");
                i++;


            }
        }

    }

    public void p2() {
        synchronized (this.r) {
            try {
                java.lang.Thread.sleep(this.inter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
