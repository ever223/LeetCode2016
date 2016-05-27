package solutions.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 16:19.
 * @DESCRIPTION:
 */
public class PalindromePairs {
    class TrieNode {
        TrieNode[] nodes;
        int index;
        public TrieNode() {
            nodes = new TrieNode[26];
            index = -1;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String s, int index) {
            TrieNode cursor = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                int pos = s.charAt(i) - 'a';
                if (cursor.nodes[pos] == null) {
                    cursor.nodes[pos] = new TrieNode();
                }
                cursor = cursor.nodes[pos];
            }
            cursor.index = index;
        }

        public void find(int curIndex, String s, List<List<Integer>> pairs) {
            TrieNode cursor = root;
            for (int i = 0; i < s.length(); i++) {
                int pos = s.charAt(i) - 'a';
                if (isPalindrome(s.substring(i))) {
                    addPair(curIndex, cursor.index, pairs);
                }
                if (cursor.nodes[pos] == null) {
                    return;
                }
                cursor = cursor.nodes[pos];
            }
            find(cursor, "", curIndex, pairs);
        }
        public void find(TrieNode parent, String s, int curIndex, List<List<Integer>> pairs) {
            if (isPalindrome(s)) {
                addPair(curIndex, parent.index, pairs);
            }
            for (int i = 0; i < 26; i++) {
                if (parent.nodes[i] != null) {
                    char c = (char) (i + 'a');
                    find(parent.nodes[i], s + c, curIndex, pairs);
                }
            }
        }
        public boolean isPalindrome(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if(s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }
        public void addPair(int index1, int index2, List<List<Integer>> pairs) {
            if (index2 == -1 || index2 == index1) {
                return;
            }
            List<Integer> pair = new ArrayList<>();
            pair.add(index1);
            pair.add(index2);
            pairs.add(pair);
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        Trie trie = new Trie();

        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            trie.find(i, words[i], pairs);
        }
        return pairs;
    }
}
