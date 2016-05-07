package solutions.backtracing;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-05 10:24.
 * @DESCRIPTION:
 */
public class DecodeWays {

    // ways[i] = ways[i - 2] + ways[i - 1]
    public int numDecodings(String s) {
        if (s == null
                || s.length() == 0
                || s.charAt(0) == '0') {
            return 0;
        }
        int[] ways = new int[s.length() + 1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 1; i < s.length(); i ++) {
            int num1 = s.charAt(i - 1) - '0';
            int num2 = s.charAt(i) - '0';
            if(num1 == 1 || (num1 == 2 && num2 <= 6)) {
                if(num2 == 0) {
                    ways[i + 1] = ways[i - 1];
                } else {
                    ways[i + 1] = ways[i] + ways[i - 1];
                }
            } else {
                if(num2 != 0) {
                    ways[i + 1] = ways[i];
                } else {
                    return 0;
                }
            }
        }
        return ways[s.length()];
    }

    public int numDecodings2(String s) {
        if (s == null
                || s.length() == 0
                || s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1;
        int cur = 1;
        for(int i = 1; i < s.length(); i ++) {
            int num1 = s.charAt(i - 1) - '0';
            int num2 = s.charAt(i) - '0';
            if(num1 == 1 || (num1 == 2 && num2 <= 6)) {
                int temp = cur;
                if(num2 == 0) {
                    cur = pre;
                } else {
                    cur += pre;
                }
                pre = temp;
            } else {
                if(num2 != 0) {
                    pre = cur;
                } else {
                    return 0;
                }
            }
        }
        return cur;
    }


    // 递归，超时
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return  numDecodings(0, s);
    }
    public int numDecodings(int begin, String s) {
        if (begin == s.length()) {
            return 1;
        }

        int num = s.charAt(begin) - '0';
        int ways = 0;
        if (num == 0) {
            return 0;
        }
        if (num < 10) {
           ways = numDecodings(begin + 1, s);
        }
        if (begin + 1 < s.length()) {
           num = num * 10 + s.charAt(begin + 1) - '0';
            if (num > 9 && num < 27) {
                ways += numDecodings(begin + 2, s);
            }
        }
        return ways;
    }
    public static void main(String[] args) {
        DecodeWays codes = new DecodeWays();
        System.out.println(codes.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
    }
}
