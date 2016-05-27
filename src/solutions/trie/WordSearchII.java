package solutions.trie;

import java.io.File;
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
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, visited, root, trie, result);
            }
        }

        return result;
    }
    public void dfs(int i, int j, char[][] board, boolean[][] visited, TrieNode parent, Trie trie, List<String> result) {
        if (i < 0
                || i == board.length
                || j < 0
                || j == board[0].length
                || visited[i][j]) {
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

        visited[i][j] = true;

        dfs(i - 1, j, board, visited, node, trie, result);
        dfs(i + 1, j, board, visited, node, trie, result);
        dfs(i, j - 1, board, visited, node, trie, result);
        dfs(i, j + 1, board, visited, node, trie, result);

        visited[i][j] = false;
    }
}
