/*------------------------
Max Non Negative SubArray
Find out the maximum sub-array of non negative numbers from an array. The sub-array should be continuous. 
That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid. 
Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B). Example:
A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length 
NOTE 2: If there is still a tie, then return the segment with minimum starting index
--------------------------*/

public class Solution {
    public int[] maxset(int[] A) {
        long sumP = 0;
        int negativeI = 0;
        int maxDiff = 0;
        int maxDiffI = -1;
        int maxi = 0;
        long max = Integer.MIN_VALUE;
        
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                sumP = sumP + A[i];
                if(max < sumP) {
                    max = sumP;
                    maxi = i;
                    maxDiff = i - negativeI;
                    maxDiffI = negativeI;
                }
                else if(max == sumP) {
                    int diff = i - negativeI;
                    if(diff > maxDiff) {
                        maxDiff = diff;
                        maxDiffI = negativeI;
                        maxi = i;
                    }
                    else if(diff == maxDiff) {
                        if(A[i] < A[maxi]) {
                            maxDiff = diff;
                            maxDiffI = negativeI;
                            maxi = i;
                        }
                    }
                }
            }
            else {
                sumP = 0;
                negativeI = i + 1;
            }
        }
        
        
        
        if(maxDiffI >= 0) {
            int[] ans = new int[maxDiff + 1];
            for(int i = 0, j = maxDiffI; j <= maxi; i++, j++) {
                ans[i] = A[j];
            }
            return ans;
        }
        else {
            return new int[0];
        }
    }
}
