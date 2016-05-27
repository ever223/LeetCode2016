package solutions.bit;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 10:18.
 * @DESCRIPTION:
 */
public class MaximumProductOfWordLengths {
    class Word {
        int charsToBits = 0;
        int length = 0;
        public Word(String s) {
            if (s != null) {
                length = s.length();
                or(s);
            }
        }
        private void or(String s) {
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                charsToBits |= (1 << c);
            }
        }
    }
    public int maxProduct(String[] words) {
        Word[] words1 = new Word[words.length];
        for (int i = 0; i < words.length; i++) {
            words1[i] = new Word(words[i]);
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words1.length; j++) {
                if ((words1[i].charsToBits & words1[j].charsToBits) == 0) {
                    max = Math.max(max, words1[i].length * words1[j].length);
                }
            }
        }
        return max;
    }

    public int maxProduct1(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if(words[i] != null) {
                for (int j = 0; j < words[i].length(); j++) {
                    mask[i] |= 1 << (words[i].charAt(j) - 'a');
                }
                for (int j = 0; j < i; j++) {
                    if (words[j] != null && (mask[i] & mask[j]) == 0) {
                        max = Math.max(max, words[i].length() * words[j].length());
                    }
                }
            }
        }
        return max;
    }
}
