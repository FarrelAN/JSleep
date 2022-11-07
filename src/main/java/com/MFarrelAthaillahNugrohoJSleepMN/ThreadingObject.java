package com.MFarrelAthaillahNugrohoJSleepMN;

public class ThreadingObject extends Thread {
    public ThreadingObject (String name) {
        super(name);
        this.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " sedang berjalan");
        System.out.println("Angka Id dari " + Thread.currentThread().getId());
    }
}
