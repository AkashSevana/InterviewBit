/*------------------------
First Missing Integer
Given an unsorted integer array, find the first missing positive integer. 
Example: Given [1,2,0] return 3, [3,4,-1,1] return 2,  [-8, -7, -6] returns 1  
Your algorithm should run in O(n) time and use constant space.
--------------------------*/

public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i = 0;
        while(i < n) {
            int index = A[i];
            if(index >= 1 && index <= n) {
                if(i + 1 != index) {
                    int temp = A[index - 1];
                    if(temp == A[i]) {
                        i++;
                        continue;
                    }
                    A[index - 1] = A[i];
                    A[i] = temp;
                    continue;
                }
                else {
                    i++;
                    continue;
                }
            }
            else {
                i++;
            }
        }
        
        for(i = 0; i < n; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}
