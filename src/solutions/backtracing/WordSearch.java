package solutions.backtracing;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-03 22:59.
 * @DESCRIPTION:
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(i, j, board, 0, chars)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist( int i, int j, char[][] board, int begin, char[] chars) {
        if (begin == chars.length) {
            return true;
        }
        if (i < 0
                || i >= board.length
                || j < 0
                || j >= board[0].length
                || (chars[begin] != board[i][j])) {
            return false;
        }
        board[i][j] ^= 256;
        boolean found = exist( i - 1, j, board, begin + 1, chars)
                || exist( i + 1, j, board, begin + 1, chars)
                || exist( i, j - 1, board, begin + 1, chars)
                || exist( i, j + 1, board, begin + 1, chars);
        board[i][j] ^= 256;
        return found;
    }
}
