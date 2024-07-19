// Link: https://leetcode.com/problems/lucky-numbers-in-a-matrix/
// Difficulty: Easy
// Time Complexity: O(n^2)
// Space Complexity: O(n)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lsRes = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++)
        {
            int col = findMin(matrix, i);

            int maxCol = matrix[i][col];
            if(maxInCol(matrix, maxCol, col))
                lsRes.add(maxCol);
        }

        return lsRes;
    }
    private int findMin(int[][] matrix, int row){
		int val= matrix[row][0], col=0;
		for(int i=1;i<matrix[row].length;i++){
			if(matrix[row][i]<val){
				val=matrix[row][i];
				col=i;
			}
		}
		return col;
	}
    private boolean maxInCol(int[][] matrix, int val, int col){
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]>val)
                return false;
        }
        return true;
    }
}