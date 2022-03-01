package at.fh.util;

public class PhilosophersConfiguration {
    private final int philosophersAmount;
    private final int thinkingTime;
    private final int eatingTime;

    public PhilosophersConfiguration(int philosophersAmount, int thinkingTime, int eatingTime) {
        this.philosophersAmount = philosophersAmount;
        this.thinkingTime = thinkingTime;
        this.eatingTime = eatingTime;
    }

    public int getPhilosophersAmount() {
        return philosophersAmount;
    }

    public int getThinkingTime() {
        return thinkingTime;
    }

    public int getEatingTime() {
        return eatingTime;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "philosophersAmount=" + philosophersAmount +
                ", thinkingTime=" + thinkingTime +
                ", eatingTime=" + eatingTime +
                '}';
    }
}
