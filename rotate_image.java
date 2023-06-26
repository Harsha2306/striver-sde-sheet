/*
Q) You are given an n x n 2D matrix representing an 
image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you 
have to modify the input 2D matrix directly. DO NOT 
allocate another 2D matrix and do the rotation.

A1) first do the transpose of the matrix then do columns 
reverse

TC - O(N2) SC - O(1)
*/

public class rotate_image {
    public void A1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

        int i = 0, j = n - 1;
        while (i < j) {
            f(i, j, m, matrix);
            i++;
            j--;
        }
    }

    void f(int c1, int c2, int r, int mat[][]) {
        for (int i = 0; i < r; i++) {
            int temp = mat[i][c1];
            mat[i][c1] = mat[i][c2];
            mat[i][c2] = temp;
        }
    }
}
