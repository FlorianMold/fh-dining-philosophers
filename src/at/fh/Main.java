package at.fh;

import at.fh.util.PhiliosophersConfiguration;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        System.out.println("Dining Philosophers problem:");
        var res = Main.readCommandLineInput();
        System.out.println(res);
    }

    /**
     * Performs reading the amount of philosophers, the thinking-time and the eating-time from the command-line.
     */
    private static PhiliosophersConfiguration readCommandLineInput() {
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

        return new PhiliosophersConfiguration(philosophersAmount, thinkingTime, eatingTime);
    }
}
