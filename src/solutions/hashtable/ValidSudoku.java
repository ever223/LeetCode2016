package solutions.hashtable;

import java.util.Arrays;

/**
 * @AUTHOR: xiaoo_gan
 * @DATE: 2016-05-01 19:54.
 * @DESCRIPTION:
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] isValid = new boolean[10];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(isValid, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (isValid[num]) {
                    return false;
                } else {
                    isValid[num] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Arrays.fill(isValid, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                int num = board[j][i] - '0';
                if (isValid[num]) {
                    return false;
                } else {
                    isValid[num] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(isValid, false);
                for (int m = 0; m < 3; m ++) {
                    for (int n = 0; n < 3; n ++) {
                        if (board[i + m][j + n] == '.') {
                            continue;
                        }
                        int num = board[i + m][j + n] - '0';
                        if (isValid[num]) {
                            return false;
                        } else {
                            isValid[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
