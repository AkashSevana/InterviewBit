/*------------------------
Pascal Triangle
Given numRows, generate the first numRows of Pascal's triangle. 
Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1. 
Example: Given numRows = 5, Return
[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
--------------------------*/

public class Solution {
    public int[][] solve(int A) {
        int[][] B = new int[A][A];
        
        for(int i = 0; i < A; i++) {
            int size = i + 1;
            B[i] = new int[size];
            for(int j = 0; j <= i; j++) {
                if(j == i || j == 0) {
                    B[i][j] = 1;
                }
                else {
                    B[i][j] = B[i - 1][j - 1] + B[i - 1][j];
                }
            }
        }
        
        return B;
    }
}
