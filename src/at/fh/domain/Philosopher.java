package at.fh.domain;

public class Philosopher implements Runnable {
    private final int id;
    private final int eatingTime;
    private final int thinkingTime;

    private final Fork leftFork;
    private final Fork rightFork;

    public Philosopher(int id, int eatingTime, int thinkingTime, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.eatingTime = eatingTime;
        this.thinkingTime = thinkingTime;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public int getId() {
        return id;
    }

    public int getEatingTime() {
        return eatingTime;
    }

    public int getThinkingTime() {
        return thinkingTime;
    }

    @Override
    public void run() {
        System.out.println("Philosopher " + this.id + " started running!");
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                ", eatingTime=" + eatingTime +
                ", thinkingTime=" + thinkingTime +
                ", leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                '}';
    }
}
