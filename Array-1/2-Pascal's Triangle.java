/**
 * Generates Pascal's triangle up to the specified number of rows.
 * Each row i has i+1 elements, where the first and last elements are 1,
 * and each middle element is the sum of the two elements directly above it.
 * Time complexity: O(numRows^2), Space complexity: O(numRows^2)
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));
        if (numRows == 1)
            return res;
        res.add(List.of(1, 1));
        if (numRows == 2)
            return res;
        numRows -= 2;
        while (numRows-- > 0) {
            List<Integer> prev = res.get(res.size() - 1);
            List<Integer> ls = new ArrayList<>();
            ls.add(1);
            for (int i = 1; i < prev.size(); i++)
                ls.add(prev.get(i - 1) + prev.get(i));
            ls.add(1);
            res.add(ls);
        }
        return res;
    }
}