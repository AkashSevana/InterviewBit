/*------------------------
Rain Water Trapped
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
Input Format
The only argument given is integer array A.
Output Format
Return the total water it is able to trap after raining..
For Example
Input 1:
    A = [0,1,0,2,1,0,1,3,2,1,2,1]
Output 1:
    6
--------------------------*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        
        int maxl = 0;
        int maxr = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > maxl) {
                maxl = A[i];
            }
            left[i] = maxl;
        }
        
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] > maxr) {
                maxr = A[i];
            }
            right[i] = maxr;
        }
        
        int water = 0;
        for(int i = 0; i < A.length; i++) {
            int store = Math.min(left[i], right[i]) - A[i];
            water += store > 0 ? store : 0;
        }
        
        return water;
    }
}
