/*------------------------
Set Matrix Zeros
Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.  
Do it in place. Example Given array A as
1 0 1
1 1 1 
1 1 1
On returning, the array A should be :
0 0 0
1 0 1
1 0 1
--------------------------*/

public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int i0 = 1, j0 = 1;
	    for(int j = 0; j < a.get(0).size(); j++) {
	        if(a.get(0).get(j) == 0) {
	            i0 = 0;
	            break;
	        }
	    }
	    
	    for(int i = 0; i < a.size(); i++) {
	        if(a.get(i).get(0) == 0) {
	            j0 = 0;
	            break;
	        }
	    }
	    
	    for(int i = 1, n = a.size(), innerN = a.get(0).size(); i < n; i++) {
	        for(int j = 1; j < innerN; j++ ) {
	            if(a.get(i).get(j) == 0) {
	                a.get(i).set(0, 0);
	                a.get(0).set(j, 0);
	            }
	        }
	    }
	    
	    for(int i = 1, n = a.size(), innerN = a.get(0).size(); i < n; i++) {
	        if(a.get(i).get(0) == 0) {
	            for(int j = 0; j < innerN; j++) {
	                a.get(i).set(j, 0);
	            }
	        }
	    }
	    
	    for(int j = 1, n = a.size(), innerN = a.get(0).size(); j < innerN; j++) {
	        if(a.get(0).get(j) == 0) {
	            for(int i = 0; i < n; i++) {
	                a.get(i).set(j, 0);
	            }
	        }
	    }
	    
	    if(i0 == 0) {
	        for(int j = 0; j < a.get(0).size(); j++) {
	            a.get(0).set(j, 0);
	        }
	    }
	    
	    if(j0 == 0) {
	        for(int i = 0; i < a.size(); i++) {
	            a.get(i).set(0, 0);
	        }
	    }

	}
}

