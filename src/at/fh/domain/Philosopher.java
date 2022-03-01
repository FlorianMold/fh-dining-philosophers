package at.fh.domain;

public class Philosopher {
    private final int id;
    private final int eatingTime;
    private final int thinkingTime;

    public Philosopher(int id, int eatingTime, int thinkingTime) {
        this.id = id;
        this.eatingTime = eatingTime;
        this.thinkingTime = thinkingTime;
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
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                ", eatingTime=" + eatingTime +
                ", thinkingTime=" + thinkingTime +
                '}';
    }
}
