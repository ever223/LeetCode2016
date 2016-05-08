package solutions.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-08 20:29.
 * @DESCRIPTION:
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if(s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> mappings = new HashMap<>();
        for(int i = 0; i < s.length(); i ++) {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            Character mapping = mappings.get(cs);
            if(mapping == null && !mappings.containsValue(ct)) {
                mappings.put(cs, ct);
            } else {
                if (mapping == ct ) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
