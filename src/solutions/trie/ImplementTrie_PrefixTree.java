package solutions.trie;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 11:17.
 * @DESCRIPTION:
 */
public class ImplementTrie_PrefixTree {
    class TrieNode {
        // Initialize your data structure here.
        private TrieNode[] nodes;
        private boolean end = false;
        public TrieNode() {
            this.nodes = new TrieNode[26];
        }
        public void putNode(int pos) {
            nodes[pos] = new TrieNode();
        }
        public TrieNode getNode(int pos) {
            return nodes[pos];
        }
        boolean getEnd() {
            return end;
        }
        void setEnd(boolean end) {
            this.end = end;
        }
    }

    class Trie {
        private TrieNode root;

        boolean isNull = false;
        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word != null) {
                TrieNode cursor = root;
                for (int i = 0; i < word.length(); i++) {
                    int pos = word.charAt(i) - 'a';
                    if (cursor.getNode(pos) == null) {
                        cursor.putNode(pos);
                    }
                    cursor = cursor.getNode(pos);
                }
                cursor.setEnd(true);
            } else {
                isNull = true;
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if(word != null) {
                TrieNode cursor = root;
                for (int i = 0; i < word.length(); i++) {
                    int pos = word.charAt(i) - 'a';
                    if (cursor.getNode(pos) == null) {
                        return false;
                    }
                    cursor = cursor.getNode(pos);
                }
                return cursor.getEnd();
            } else {
                return isNull;
            }
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix != null) {
                TrieNode cursor = root;
                for (int i = 0; i < prefix.length(); i++) {
                    int pos = prefix.charAt(i) - 'a';
                    if (cursor.getNode(pos) == null) {
                        return false;
                    }
                    cursor = cursor.getNode(pos);
                }
                return true;
            } else {
                return isNull;
            }
        }
    }
}


