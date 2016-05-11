package solutions.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-11 22:16.
 * @DESCRIPTION:
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Integer sCount = sMap.get(sc);
            sMap.put(sc, sCount == null ? 1 : sCount + 1);

            Character ts = t.charAt(i);
            Integer tCount = tMap.get(ts);
            tMap.put(ts, tCount == null ? 1 : tCount + 1);
        }

        for (Character c : sMap.keySet()) {
            if (!Objects.equals(sMap.get(c), tMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}
