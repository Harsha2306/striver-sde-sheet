/**
 * Optimize space to O(1) by using the first row and column as markers.
 * Use two flags to track if the first row/column originally contained any zeros,
 * since they get overwritten when marking other rows/columns for zeroing.
 * Time complexity: O(m * n), Space complexity: O(1)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rs = new HashSet<>(), cs = new HashSet<>();
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, colZero = false;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) {
                rowZero = true;
                break;
            }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0)
                    continue;
                else if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;

        if (rowZero)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;

        if (colZero)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }
}