package utils;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

public class RandomNumGen {
    public static boolean numberGenerator(int percent) {
        int randomNum = nextInt(100);
        if(randomNum <= (percent - 1)) return true;
        else return false;
    }
}
