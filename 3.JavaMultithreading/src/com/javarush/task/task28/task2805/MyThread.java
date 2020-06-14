package com.javarush.task.task28.task2805;

public class MyThread  extends Thread{

    private static int myPriority = MIN_PRIORITY;

    public MyThread() {
        super();
        super.setPriority(getMyPriority());
    }

    public MyThread(Runnable target) {
        super(target);
        super.setPriority(getMyPriority());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        super.setPriority(getMyPriority());

    }

    public MyThread(String name) {
        super(name);
        super.setPriority(getMyPriority());

    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        super.setPriority(getMyPriority());

    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        super.setPriority(getMyPriority());

    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        super.setPriority(getMyPriority());

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        super.setPriority(getMyPriority());

    }

    private int getMyPriority() {
        int max = MAX_PRIORITY;
        if (Thread.currentThread().getThreadGroup() != null) {
            max = Thread.currentThread().getThreadGroup().getMaxPriority();
        }
        if (myPriority > max) {
            myPriority = MIN_PRIORITY;
        }
        return myPriority++;
    }
}
