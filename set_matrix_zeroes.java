/*Q) Given an m x n integer matrix matrix, if an element is 0, set its entire 
row and column to 0's.You must do it in place.

A1) As the question says to use constant space we are not allowed to use extra 
   array, maps, lists etc
   so i used two string variables row and col and I kept on adding the indices
   with zero value to the string, After that I extracted the seperate row and 
   cols and put the values to zero

   TC - O(N3) SC - O(1)


A2) intialize two arrays of length m and n with -1's and start traversing the
    matrix. If we find zero then mark the respective row and col as zero
    Again traverse the matrix and change values to zero if row[i] == 0 || col[j]
    ==0
     
    TC - O(N2) SC - O(M+N)
*/

import java.util.Arrays;

public class set_matrix_zeroes {
    public void A1(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        String row = "", col = "";
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) {
                    row += i + " ";
                    col += j + " ";
                }
        int start = 0, end = 0;
        while (end < row.length()) {
            while (end < row.length() && row.charAt(end) != ' ')
                end++;
            int temp = Integer.parseInt(row.substring(start, end));
            putColumnZero(temp, mat);
            start = ++end;
        }
        start = 0;
        end = 0;
        while (end < col.length()) {
            while (end < col.length() && col.charAt(end) != ' ')
                end++;
            int temp = Integer.parseInt(col.substring(start, end));
            putRowZero(temp, mat);
            start = ++end;
        }
    }

    void putRowZero(int c, int mat[][]) {
        for (int i = 0; i < mat.length; i++)
            mat[i][c] = 0;
    }

    void putColumnZero(int r, int mat[][]) {
        for (int i = 0; i < mat[0].length; i++)
            mat[r][i] = 0;
    }
    // ------------------------------------------------------------------------------------
    public void A2(int[][] mat) {
        int m = mat.length, n = mat[0].length, row[] = new int[m], col[] = new int[n];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (row[i] == 0 || col[j] == 0)
                    mat[i][j] = 0;
    }
    // ------------------------------------------------------------------------------------
    public void A3(int[][] mat) {
        int m = mat.length, n = mat[0].length, row0 = mat[0][0];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 0) {
                    if (i == 0) {
                        row0 = 0;
                    }
                    else {
                        mat[0][j] = 0;
                        mat[i][0] = 0;
                    }
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i == 0) {
                    if(mat[0][j] == 0 || row0 == 0)
                        mat[i][j] = 0;
                }
                else {
                    if(mat[0][j] == 0 || mat[i][0] == 0)
                        mat[i][j] = 0;
                }
    }

}

