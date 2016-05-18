package solutions.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-17 23:16.
 * @DESCRIPTION:
 */
public class IntegerToEnglishWords {
    // 1,000,000,000
    public final static String[] lessThanTwenty = {
            "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public final static String[] lessThanHundred = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };
    public final static String[] nums = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        String words = "";
        List<Integer> digits = new ArrayList<>();
        while(num != 0 || digits.size() % 3 != 0) {
            digits.add(0, num % 10);
            num /= 10;
        }
        int round = digits.size() / 3;
        for (int i = 0; i < digits.size(); i += 3) {
            String word = underThousand(digits, i);
            if (!word.equals("")) {
                words += " " + word;
                if (round > 1) {
                    words += " " + nums[round - 1];
                }
            }
            round --;
        }
        return words.equals("") ?  "Zero" : words.substring(1);
    }
    public String underThousand(List<Integer> digits, int start) {
        String words = "";
        int bai = digits.get(start);
        int shi = digits.get(start + 1);
        int ge = digits.get(start + 2);
        if (bai != 0) {
            words = lessThanTwenty[bai] + " Hundred";
        }
        if (shi != 0) {
            if (shi == 1) {
                if (!words.equals("")) {
                    words += " " + lessThanTwenty[shi * 10 + ge];
                } else {
                    words = lessThanTwenty[shi * 10 + ge];
                }
                return words;
            } else {
                if (!words.equals("")) {
                    words += " " + lessThanHundred[shi];
                } else {
                    words = lessThanHundred[shi];
                }
            }
        }
        if (ge != 0) {
            if (!words.equals("")) {
                words += " " + lessThanTwenty[ge];
            } else {
                words = lessThanTwenty[ge];
            }
        }
        return words;
    }
}
