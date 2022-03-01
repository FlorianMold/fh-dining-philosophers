package at.fh;

import at.fh.domain.Fork;
import at.fh.domain.Philosopher;
import at.fh.util.PhilosophersConfiguration;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        System.out.println("Dining Philosophers problem:");
        var config = Main.readCommandLineInput();

        // There are as many forks as philosophers.
        var forks = createForks(config.getPhilosophersAmount());
        var philosophers = createPhilosophers(config);

    }

    /**
     * Generates as many forks as specified in the forkAmount.
     *
     * @param forkAmount The amount of forks to create.
     * @return An array of newly created forks with the length of the forkAmount
     */
    private static Fork[] createForks(final int forkAmount) {
        var forks = new Fork[forkAmount];
        for (int i = 0; i < forkAmount; i++) {
            forks[i] = new Fork(i);
        }

        return forks;
    }

    /**
     * Generates as many philosophers as specified in the PhilosophersConfiguration.
     * The philosophers get their thinking-time and eating-time from the PhilosophersConfiguration.
     *
     * @param conf The configuration-object needed for creating objects.
     * @return An array of newly created philosophers with the length of the PhilosophersConfiguration.
     */
    private static Philosopher[] createPhilosophers(final PhilosophersConfiguration conf) {
        var philosophersAmount = conf.getPhilosophersAmount();
        var philosophers = new Philosopher[philosophersAmount];

        for (int i = 0; i < philosophersAmount; i++) {
            philosophers[i] = new Philosopher(i, conf.getEatingTime(), conf.getThinkingTime());
        }

        return philosophers;
    }

    /**
     * Performs reading the amount of philosophers, the thinking-time and the eating-time from the command-line.
     *
     * @return A PhilosophersConfiguration with the read properties.
     */
    private static PhilosophersConfiguration readCommandLineInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the amount of philosophers:");
        final int philosophersAmount = scanner.nextInt();
        System.out.println("You entered: " + philosophersAmount);

        System.out.println("Please enter the thinking-time:");
        final int thinkingTime = scanner.nextInt();
        System.out.println("You entered: " + thinkingTime);

        System.out.println("Please enter the eating-time:");
        final int eatingTime = scanner.nextInt();
        System.out.println("You entered: " + eatingTime);

        return new PhilosophersConfiguration(philosophersAmount, thinkingTime, eatingTime);
    }
}
