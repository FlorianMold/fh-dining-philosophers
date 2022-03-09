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

    private long programTime;
    private long waitingTimeLeftFork;
    private long waitingTimeRightFork;

    @Override
    public void run() {
        System.out.println(this.getName() + " started running!");

        var forkOrder = this.isEven() ?
                new Fork[]{this.rightFork, this.leftFork} : new Fork[]{this.leftFork, this.rightFork};
        var takeOrder = this.isEven() ?
                new String[]{"right", "left"} : new String[]{"left", "right"};

        this.programTime = System.currentTimeMillis();
        while (this.isRunning) {
            try {
                this.think();
                var currentTimeLeft = System.currentTimeMillis();
                synchronized (forkOrder[0]) {
                    this.waitingTimeLeftFork += System.currentTimeMillis() - currentTimeLeft;

                    this.takeFork(forkOrder[0], takeOrder[0]);
                    // Thread.sleep(5000);
                    var currentTimeRight = System.currentTimeMillis();
                    synchronized (forkOrder[1]) {
                        this.waitingTimeRightFork += System.currentTimeMillis() - currentTimeRight;

                        this.takeFork(forkOrder[1], takeOrder[1]);
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
        System.out.println("Total running time: " + (System.currentTimeMillis() - this.programTime) + "s");
        System.out.println("Waiting for the left fork: " + this.waitingTimeLeftFork + "s");
        System.out.println("Waiting for the right fork: " + this.waitingTimeRightFork + "s");
    }

    /**
     * The philosopher thinks for a time.
     *
     * @throws InterruptedException - if the thread was interrupted
     */
    public void think() throws InterruptedException {
        var thinkingTime = NumberGenerator.generateNumber(0, this.thinkingTime);
        Thread.sleep(thinkingTime);
        System.out.println(this.getName() + " finished thinking!");
    }

    /**
     * The function take a fork with the given side.
     *
     * @param fork The fork to take.
     * @param side The side of the fork to take.
     */
    public void takeFork(final Fork fork, final String side) {
        System.out.println(this.getName() + " has taken the " + side + " fork with id " + fork.getId());
    }

    /**
     * The philosopher eats.
     */
    public void eat() throws InterruptedException {
        var eatingTime = NumberGenerator.generateNumber(0, this.eatingTime);
        Thread.sleep(eatingTime);
        System.out.println(this.getName() + " is done eating!");
    }

    /**
     * Puts down the left fork.
     *
     * @param fork The fork to put down.
     */
    public void putDownLeftFork(final Fork fork) {
        System.out.println(this.getName() + " is putting down the left fork with id " + fork.getId());
    }

    /**
     * Puts down the right fork.
     *
     * @param fork the fork to put down.
     */
    public void putDownRightFork(final Fork fork) {
        System.out.println(this.getName() + " is putting down the right fork with id " + fork.getId());
    }

    /**
     * Stops the execution of the thread.
     */
    public void stopRunning() {
        this.isRunning = false;
    }

    /**
     * Whether the id of the philosopher is even.
     */
    private boolean isEven() {
        return this.id % 2 == 0;
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
