package solutions.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-04 22:16.
 * @DESCRIPTION:
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<String>();
        restoreIpAddresses(0, 0, "", addresses, s);
        return addresses;
    }
    public void restoreIpAddresses(int start, int k, String address, List<String> addresses, String s) {

        if(start == s.length() && k == 4) {
            addresses.add(address.substring(1));
            return;
        }

        if(k == 4 || start == s.length()) {
            return;
        }

        int num1 = s.charAt(start) - '0';
        restoreIpAddresses(start + 1, k + 1, address + "." + num1, addresses, s);
        if(num1 == 0 || start + 1 >= s.length()) {
            return;
        }

        int num2 = s.charAt(start + 1) - '0' + num1 * 10;
        restoreIpAddresses(start + 2, k + 1, address + "." + num2, addresses, s);
        if(start + 2 >= s.length()) {
            return;
        }

        int num3 = s.charAt(start + 2) - '0' + num2 * 10;
        if(num3 < 256) {
            restoreIpAddresses(start + 3, k + 1, address + "." + num3, addresses, s);
        }
    }
}
