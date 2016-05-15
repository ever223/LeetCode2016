package solutions.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-15 12:13.
 * @DESCRIPTION:
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        String[] subs = str.split(" ");
        if (subs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String pStr = subs[i];
            if (map.containsKey(c) && !map.get(c).equals(pStr) || !map.containsKey(c) && map.containsValue(pStr)) {
                return false;
            } else {
                if (!map.containsKey(c)) {
                    map.put(c, pStr);
                }
            }
        }
        return true;
    }
}
