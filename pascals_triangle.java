/*
Q) Given an integer numRows, return the first numRows of Pascal's 
  triangle.
A1) I have done as the question says
    TC - O(N2) SC - O(N2)
 */

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {
    public List<List<Integer>> A1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        res.add(al);
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> prev = res.get(res.size() - 1), curr = new ArrayList<>();
            curr.add(prev.get(0));
            for (int j = 0; j < prev.size() - 1; j++)
                curr.add(prev.get(j) + prev.get(j + 1));
            curr.add(prev.get(prev.size() - 1));
            res.add(curr);
        }
        return res;
    }
}
