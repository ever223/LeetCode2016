package solutions.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-27 14:44.
 * @DESCRIPTION:
 */
public class WordSearchII {
    class TrieNode {
        private TrieNode[] nodes;
        private String fullString = null;
        public TrieNode() {
            nodes = new TrieNode[26];
        }
        public void put(int pos) {
            nodes[pos] = new TrieNode();
        }
        public boolean contain(int pos) {
            return nodes[pos] != null;
        }
        public TrieNode get(int pos) {
            return nodes[pos];
        }
        public void SetFullString(String str) {
            this.fullString = str;
        }
        public String getFullString() {
            return this.fullString;
        }

    }
    class Trie {
        TrieNode root;
        public Trie(TrieNode root) {
            this.root = root;
        }
        public void insert(String s) {
            TrieNode cursor = root;
            for (int i = 0; i < s.length(); i++) {
                int pos = s.charAt(i) - 'a';
                if (cursor.get(pos) == null) {
                    cursor.put(pos);
                }
                cursor = cursor.get(pos);
            }
            cursor.SetFullString(s);
        }

        public TrieNode find(int pos,  TrieNode parent) {
            return parent.get(pos);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        Trie trie = new Trie(root);
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, trie, result);
            }
        }

        return result;
    }
    public void dfs(int i, int j, char[][] board, TrieNode parent, Trie trie, List<String> result) {
        if (board[i][j] == '#') {
            return;
        }
        int pos = board[i][j] - 'a';
        TrieNode node = trie.find(pos, parent);
        if (node == null) {
            return;
        }
        if (node.getFullString() != null) {
            result.add(node.getFullString());
            node.SetFullString(null);
        }
        char c = board[i][j];
        board[i][j] = '#';
        if (i > 0) {
            dfs(i - 1, j, board, node, trie, result);
        }
        if(i < board.length - 1) {
            dfs(i + 1, j, board,  node, trie, result);
        }
        if(j > 0) {
            dfs(i, j - 1, board, node, trie, result);
        }
        if(j < board[0].length - 1) {
            dfs(i, j + 1, board,  node, trie, result);
        }
        board[i][j] = c;
    }
}
