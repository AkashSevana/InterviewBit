/*------------------------
Maximum Unsorted Subarray
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,..., AN-1. 
Find the minimum sub array Al, Al+1 ,..., Ar so if we sort(in ascending order) that sub array, 
then the whole array should get sorted. If A is already sorted, output -1. Example :
Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
--------------------------*/

public class Solution {
    public int[] subUnsort(int[] A) {
        int n = A.length;
        int start = 0, end = n - 1;
        for(start = 0; start < n - 1; start++) {
            if(A[start] > A[start + 1]) {
                break;
            }
        }
        
        for(end = n - 2; end >= 0; end--) {
            if(A[end] > A[end + 1]) {
                end = end + 1;
                break;
            }
        }
        
        if(start > end) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        else {
            int[] minMax = findMinMax(A, start, end);
            for(int i = 0; i < start; i++) {
                if(A[i] > minMax[1]) {
                    start = i;
                    break;
                }
            }
            
            for(int i = n - 1; i > end; i--) {
                if(A[i] < minMax[0]) {
                    end = i;
                    break;
                }
            }
            int[] ans = new int[2];
            ans[0] = start;
            ans[1] = end;
            
            return ans;
        }
    }
    
    public int[] findMinMax(int[] A, int start, int end) {
        int[] ans = new int[2];
        ans[1] = A[start];
        ans[0] = ans[1];
        for(int i = start; i <= end; i++) {
            if(A[i] > ans[0]) {
                ans[0] = A[i];
            }
            if(A[i] < ans[1]) {
                ans[1] = A[i];
            }
        }
        return ans;
    }
}
