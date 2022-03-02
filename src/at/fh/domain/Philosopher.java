package at.fh.domain;

import at.fh.util.NumberGenerator;

public class Philosopher implements Runnable {
    private final int id;
    private final int eatingTime;
    private final int thinkingTime;

    private final Fork leftFork;
    private final Fork rightFork;

    private boolean isRunning = true;

    public Philosopher(int id, int eatingTime, int thinkingTime, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.eatingTime = eatingTime;
        this.thinkingTime = thinkingTime;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public String getName() {
        return "Philosopher-" + this.id;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started running!");

        while (this.isRunning) {
            try {
                this.think();
                synchronized (this.leftFork) {
                    this.takeLeftFork(this.leftFork);
//                    Thread.sleep(5000);
                    synchronized (this.rightFork) {
                        this.takeRightFork(this.rightFork);
                        this.eat();
                        this.putDownRightFork(this.rightFork);
                    }
                    this.putDownLeftFork(this.leftFork);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }

        System.out.println(this.getName() + " stopped running!");
    }

    public void think() throws InterruptedException {
        var thinkingTime = NumberGenerator.generateNumber(0, this.thinkingTime);
        Thread.sleep(thinkingTime);
        System.out.println(this.getName() + " finished thinking!");
    }

    public void takeLeftFork(final Fork fork) {
        System.out.println(this.getName() + " has taken the left fork with id " + fork.getId());
    }

    public void takeRightFork(final Fork fork) {
        System.out.println(this.getName() + " has taken the right fork with id " + fork.getId());
    }

    public void eat() throws InterruptedException {
        var eatingTime = NumberGenerator.generateNumber(0, this.eatingTime);
        Thread.sleep(eatingTime);
        System.out.println(this.getName() + " is done eating!");
    }

    public void putDownLeftFork(final Fork fork) {
        System.out.println(this.getName() + " is putting down the left fork with id " + fork.getId());
    }

    public void putDownRightFork(final Fork fork) {
        System.out.println(this.getName() + " is putting down the right fork with id " + fork.getId());
    }

    /**
     * Stops the execution of the thread.
     */
    public void stopRunning() {
        this.isRunning = false;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                ", eatingTime=" + eatingTime +
                ", thinkingTime=" + thinkingTime +
                ", leftFork=" + leftFork.getId() +
                ", rightFork=" + rightFork.getId() +
                '}';
    }
}
