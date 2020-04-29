/*------------------------
Min XOR value
Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value. Examples :
Input
0 2 5 7
Output
2 (0 XOR 2)
Input
0 4 7 9
Output
3 (4 XOR 7) Constraints:
2 <= N <= 100 000
0 <= A[i] <= 1 000 000 000
--------------------------*/

public class Solution {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        int x = 0;

        for (int i = 0, n = A.length; i < n - 1; i++) { 
            x = A[i] ^ A[i + 1];
            min = Math.min(min, x);
        }
        return min; 
    }
}
