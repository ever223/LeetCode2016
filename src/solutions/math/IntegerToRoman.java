package solutions.math;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-30 14:54.
 * @DESCRIPTION:
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 *
 */
public class IntegerToRoman {
//   public static Map<Integer, String> m = new LinkedHashMap<>();
//    static {
//        m.put(1000, "M");
//        m.put(900, "CM");
//        m.put(500, "D");
//        m.put(400, "CD");
//        m.put(100, "C");
//        m.put(90, "XC");
//        m.put(50, "L");
//        m.put(40, "XL");
//        m.put(10, "X");
//        m.put(9, "IX");
//        m.put(5, "V");
//        m.put(4, "IV");
//        m.put(1, "I");
//    }
    public String intToRoman(int num) {
        Integer[] radixs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4 , 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String romanNum = "";
        for (int i = 0; i < radixs.length; i++) {
            int count = num / radixs[i];
            while (count != 0) {
                romanNum += symbols[i];
                count --;
            }
            num %= radixs[i];
        }
        return romanNum;
    }
}
