package solutions.backtracing;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 22:59.
 * @DESCRIPTION:
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(visited, i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(boolean[][] visited, int i, int j, char[][] board, int begin, String word) {
        if (begin == word.length()) {
            return true;
        }
        if (i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length
                || visited[i][j]
                || (word.charAt(begin) != board[i][j])) {
            return false;
        }
        visited[i][j] = true;
        boolean found = exist(visited, i - 1, j, board, begin + 1, word)
                || exist(visited, i + 1, j, board, begin + 1, word)
                || exist(visited, i, j - 1, board, begin + 1, word)
                || exist(visited, i, j + 1, board, begin + 1, word);
        visited[i][j] = false;
        return found;
    }
}
