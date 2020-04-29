/*------------------------
Next Permutation
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers. 
If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order. 
The replacement must be in-place, do not allocate extra memory. Examples:
1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points. 
--------------------------*/

public class Solution {
	public void nextPermutation(ArrayList<Integer> A) {
	    int x = -1;
	    for(int i = A.size() - 1; i > 0; i--) {
	        if(A.get(i) > A.get(i - 1)) {
	            x = i - 1;
	            break;
	        }
	    }
	    
	    if(x >= 0) {
	        for(int i = A.size() - 1; i > x; i--) {
	            if(A.get(i) > A.get(x)) {
	                int temp = A.get(i);
	                A.set(i, A.get(x));
	                A.set(x, temp);
	                break;
	            }
	        }
	        reverse(A, x + 1, A.size() - 1);
	    }
	    else {
	        reverse(A, 0, A.size() - 1);
	    }
	}
	
	public void reverse(ArrayList<Integer> A, int low, int high) {
	    while(low < high) {
	        int temp = A.get(low);
	        A.set(low, A.get(high));
	        A.set(high, temp);
	        low++;
	        high--;
	    }
	}
}