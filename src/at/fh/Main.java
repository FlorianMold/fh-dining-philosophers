package at.fh;

import at.fh.domain.Philosopher;
import at.fh.util.PhilosophersConfiguration;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        System.out.println("Dining Philosophers problem:");
        var config = Main.readCommandLineInput();

        var philosophers = createPhilosophers(config);
        System.out.println(philosophers.length);
    }

    /**
     * Generates a specified amount of philosophers. The amount is specified inside the PhilosophersConfiguration.
     * The philosophers receive their thinking-time and eating-time from the PhilosophersConfiguration.
     *
     * @param conf The configuration-object needed for creating objects.
     * @return An array of newly created philosophers with the specified length.
     */
    private static Philosopher[] createPhilosophers(PhilosophersConfiguration conf) {
        var philosophersAmount = conf.getPhilosophersAmount();
        var philosophers = new Philosopher[philosophersAmount];

        for (int i = 0; i < philosophersAmount; i++) {
            philosophers[i] = new Philosopher(i, conf.getEatingTime(), conf.getThinkingTime());
        }

        return philosophers;
    }

    /**
     * Performs reading the amount of philosophers, the thinking-time and the eating-time from the command-line.
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
