package solutions.math;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-04-29 16:50.
 * @DESCRIPTION:
 */
public class PalindromeNumber {

    // used extra space
    public boolean isPalindrome1(int x) {
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length() - 1;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            return false;
        }

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int count = 0;
        int temp = x;
        while (temp != 0) {
            count ++;
            temp /= 10;
        }
        while(count > 1) {
            int right = x % 10;
            int base = 1;
            for (int i = 1; i < count; i ++) {
                base *= 10;
            }
            int left = x / base;
            if (right != left) {
                return false;
            }
            x %= base;
            x/= 10;
            count = count - 2;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(133333));
        System.out.println(isPalindrome(14312));
        System.out.println(isPalindrome(456654));
        System.out.println(isPalindrome(4567654));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(1000021));
    }
}
