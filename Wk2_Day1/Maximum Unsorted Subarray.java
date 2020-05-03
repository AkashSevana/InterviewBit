/*------------------------
Maximum Unsorted Subarray
Problem Description
Given an array A of non-negative integers of size N. 
Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, 
then the whole array should get sorted. If A is already sorted, output -1.


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000


Input Format
First and only argument is an array of non-negative integers of size N.


Output Format
Return an array of length 2 where First element denotes the starting index(0-based) and second element denotes the ending index(0-based) of the sub-array. If the array is already sorted, return an array containing only one element i.e. -1.


Example Input
Input 1:
A = [1, 3, 2, 4, 5]
Input 2:
A = [1, 2, 3, 4, 5]
  


Example Output
Output 1:
[1, 2]
Output 2:
[-1]
  


Example Explanation
Explanation 1:
If we sort the sub-array A1, A2, then the whole array A gets sorted.

--------------------------*/

public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int i = 0;
        int n = A.size();
        int j = n - 1;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        while(i < n - 1) {
            if(A.get(i) > A.get(i + 1))
                break;
            //index.put(A.get(i), i);
            i++;
        }
        
        while(j > 0) {
            if(A.get(j) < A.get(j - 1))
                break;
            //index.put(A.get(j), j);
            j--;
        }
        
        if(i > j) {
            answer.add(-1);
            return answer;
        }
        else {
            answer.add(i);
            answer.add(j);
        }
        
        int min = A.get(Math.max(i - 1, 0));
        int max = A.get(Math.min(j + 1, n - 1));
        
        for(int k = i; k <= j; k++) {
            min = Math.min(min, A.get(k));
            max = Math.max(max, A.get(k));
        }
        
        if(min != A.get(Math.max(i - 1, 0))) {
            for(i = 0; i < n; i++)
                if(A.get(i) > min) {
                    min = Math.max(i, 0);
                    break;
                }
            answer.set(0, min);
        }
        
        if(max != A.get(Math.min(j + 1, n - 1))) {
            for(j = n - 1; j >= 0; j--) {
                if(A.get(j) < max) {
                    max = Math.min(j, n - 1);
                    break;
                }
            }
            answer.set(1, max);
        }
        
        return answer;
    }
}

