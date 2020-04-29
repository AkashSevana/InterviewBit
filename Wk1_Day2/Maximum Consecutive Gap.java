/*------------------------
Maximum Consecutive Gap
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space. Example :
Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.
You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
--------------------------*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        if(A.length < 2) {
            return 0;
        }
        
        int maxVal = -1;
        int minVal = Integer.MAX_VALUE;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] > maxVal) {
                maxVal = A[i];
            }
            if(A[i] < minVal) {
                minVal = A[i];
            }
        }
        
        double gap = (double) (maxVal - minVal) / (double) (A.length - 1);
        if(gap < 1) {
            return maxVal - minVal;
        }
        
        int[] max = new int[A.length];
        int[] min = new int[A.length];
        
        for(int i = 0; i < A.length; i++) {
            int index = (int) Math.round((A[i] - minVal) / gap);
            if(A[i] == minVal || A[i] == maxVal) {
                continue;
            }
            
            if(min[index] == 0) {
                min[index] = A[i];
            }
            else {
                min[index] = Math.min(min[index], A[i]);
            }
            
            if(max[index] == 0) {
                max[index] = A[i];
            }
            else {
                max[index] = Math.max(max[index], A[i]);
            }
        }
        
        int minValue = minVal;
        int maxDiff = 0;
        for(int i = 0; i < A.length; i++) {
            if(max[i] == 0) {
                continue;
            }
            maxDiff = Math.max(min[i] - minValue, maxDiff);
            maxDiff = Math.max(max[i] - min[i], maxDiff);
            minValue = max[i];
        }
        maxDiff = Math.max(maxVal - minValue, maxDiff);
        
        return maxDiff;
    }
}

