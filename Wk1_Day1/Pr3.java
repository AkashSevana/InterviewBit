/*------------------------
N/3 Repeat Number
You're given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space. If so, return the integer. If not, return -1. If there are multiple solutions, return any one.  Example :
Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 
--------------------------*/

public class Solution {
	public int repeatedNumber(final List<Integer> alist) {
	    int a[] = new int[2];
	    int b[] = new int[2];
	    int n = alist.size();
	    for(int i = 0; i < n; i++) {
	        int x = alist.get(i);
	        if(a[0] == x) {
	            a[1]++;
	        }
	        else if(b[0] == x) {
	            b[1]++;
	        }
	        else {
	            if(a[1] == 0) {
	                a[0] = x;
	                a[1]++;
	            }
	            else if(b[1] == 0) {
	                b[0] = x;
	                b[1]++;
	            }
	            else {
	                b[1]--;
	                a[1]--;
	            }
	        }
	    }
	    //System.out.println(a[0] + " " + b[0]);
	    int count = 0;
	    for(Integer x : alist) {
	        if(x == a[0]) {
	            count++;
	        }
	        //System.out.println(count);
	        if(count > n / 3){
	            return a[0];
	        }
	    }
	    
	    count = 0;
	    for(Integer x : alist) {
	        if(x == b[0]) {
	            count++;
	        }
	        if(count > n / 3){
	            return b[0];
	        }
	    }
	    
	    return -1;
	}
}
