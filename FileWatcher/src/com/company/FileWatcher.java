package com.company;

import java.io.File;
import java.util.ArrayList;

public class FileWatcher {
    public String adress;
    public long interval;
    public File file;
    public Runnable r;

    public FileWatcher(String dir, long pollingInterval) {
        this.adress = dir;
        this.interval = pollingInterval;
    }

    ArrayList<File> filearray = new ArrayList<>();
    ArrayList<File> filesarray2 = new ArrayList<>();

    public void watch() {

        File n = new File(adress);
        for (File file : n.listFiles()) {
            if (file.isFile()) {
                filearray.add(file);
            }
        }
        filearray = filesarray2;
        TreadExampl te = new TreadExampl();
        te.filearrayyy = this.filearray;
        te.filesarrayyy2 = this.filesarray2;
        te.inter = this.interval;
        Thread t1 = new Thread(te::p1);
        Thread t2 = new Thread(te::p2);
        t1.start();
        t2.start();


        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }


}








