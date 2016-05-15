package solutions.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 16:56.
 * @DESCRIPTION:
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] sCount = new int[10];
        int[] gCount = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int sc = secret.charAt(i) - '0';
            int gc = guess.charAt(i) - '0';
            if (sc == gc) {
                bulls ++;
            } else {
                sCount[sc] ++;
                gCount[gc] ++;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (sCount[i] != 0) {
                cows += Math.min(sCount[i], gCount[i]);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
