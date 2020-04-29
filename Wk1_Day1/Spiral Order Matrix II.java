/*------------------------
Spiral Order Matrix II
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. 
Example: Given n = 3, You should return the following matrix:
[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
--------------------------*/

public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        int i = 1;
        int rowi = 0;
        int coli = 0;
        int dir = 1;
        int r = A - 1, l = 0, b = A - 1, t = 1;
        while(i <= A * A) {
            if(dir == 1) {
                matrix[rowi][coli] = i;
                if(coli == r) {
                    r--;
                    dir = 2;
                    rowi++;
                    i++;
                    continue;
                }
                coli++;
            }
            else if(dir == 2) {
                matrix[rowi][coli] = i;
                if(rowi == b) {
                    b--;
                    dir = -1;
                    coli--;
                    i++;
                    continue;
                }
                rowi++;
            }
            else if(dir == -1) {
                matrix[rowi][coli] = i;
                if(coli == l) {
                    l++;
                    dir = -2;
                    rowi--;
                    i++;
                    continue;
                }
                coli--;
            }
            else if(dir == -2) {
                matrix[rowi][coli] = i;
                if(rowi == t) {
                    t++;
                    dir = 1;
                    coli++;
                    i++;
                    continue;
                }
                rowi--;
            }
            i++;
        }
        return matrix;
    }
}
