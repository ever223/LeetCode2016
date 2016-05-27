package solutions.trie;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 13:24.
 * @DESCRIPTION:
 */
public class AddAndSearchWord_DataStructureDesign {
    class WordDictionary {

        private TrieNode root = new TrieNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TrieNode cursor = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (cursor.getNode(pos) == null) {
                    cursor.putNode(pos);
                }
                cursor = cursor.getNode(pos);
            }
            cursor.setEnd(true);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(word, root);
        }
        public boolean search(String word, TrieNode parent) {
            TrieNode cursor = parent;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c == '.') {
                    for (int j = 0; j < 26; j++) {
                        if (cursor.getNode(j) != null) {
                            if(search(word.substring(i + 1), cursor.getNode(j))) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    if (cursor.getNode(c - 'a') != null) {
                        cursor = cursor.getNode(c - 'a');
                    } else {
                        return false;
                    }
                }
            }
            return cursor.getEnd();
        }
    }
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
}








// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
