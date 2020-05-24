package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private final Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State stateTargetPrev = null;
        State stateTarget;
        do {
            stateTarget = target.getState();
            if (stateTarget != stateTargetPrev)
                System.out.println(stateTarget);
            stateTargetPrev = stateTarget;
        } while (stateTarget != State.TERMINATED);
    }
}
