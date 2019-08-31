/*------------------------
Max Sum Contiguous Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example: Given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
For this problem, return the maximum sum.
--------------------------*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int max = A[0];
        for(int i = 1, n = A.length; i < n; i++) {
            A[i] = Math.max(A[i-1], 0) + A[i];
            if(max < A[i]){
                max = A[i];
            }
        }
        return max;
    }
}
