/*------------------------
Repeat and Missing Number Array
You are given a read only array of n integers from 1 to n.  Each integer appears exactly once except A which appears twice and B which is missing. Return A and B.  Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? Note that in your output A should precede B.  Example:
Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
--------------------------*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        long sum = 0;
        long SUM = 0;
        long squareSum = 0;
        long squareSUM = 0;
        int n = A.length;
        for(int i = 0; i < n; i++) {
            sum += A[i];
            SUM += (i + 1);
            squareSum += ((long)A[i]) * ((long)A[i]);
            squareSUM += ((long)(i + 1)) * ((long)(i + 1));
        }
        
        long eq1 = SUM - sum;
        long eq2 = (squareSUM - squareSum) / eq1;
        
        int[] ans = new int[2];
        ans[1] = (int) ((eq1 + eq2) / 2);
        ans[0] = (int) ((eq2 - eq1) / 2);
        
        return ans;
    }
}
