package com.liuyk.demo;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t hhhhhh");
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }


    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t myUnLock");
    }

    public static void main(String[] args) {
            SpinLock spinLock = new SpinLock();
            new Thread(()->{
                spinLock.myLock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                spinLock.myUnLock();

            },"Aa").start();

            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            new Thread(()->{
                spinLock.myLock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                spinLock.myUnLock();

            },"Bb").start();

    }
}
