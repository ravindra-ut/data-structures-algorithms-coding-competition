/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:

1) Integers in each row are sorted from left to right.
2) The first integer of each row is greater than the last integer of the previous row.

For example, consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Search2DMatrix {
    // modified binary search
    public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        return false;
      }
      
      int row = matrix.length; 
      int column = matrix[0].length;
        
      int start = 0;
      int end = row * column - 1;
        
      while(start <= end){
        int mid = start + (end - start)/2;
        int midRow = mid / column;
        int midCol = mid % column;
        
        if(matrix[midRow][midCol] == target){
          return true;
        } else if(matrix[midRow][midCol] < target){
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
      return false;
    }
}