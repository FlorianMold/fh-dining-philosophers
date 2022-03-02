package at.fh.util;

import java.util.Random;

public interface NumberGenerator {

    /**
     * Generates a random number, which is in the interval [min <= x <= max].
     *
     * @param min The minimum number of the generator.
     * @param max The maximum number of the generator.
     * @return The generated number between the boundaries.
     */
    static int generateNumber(int min, int max) {
        Random rng = new Random();
        return rng.nextInt(max - min) + min;
    }
}
