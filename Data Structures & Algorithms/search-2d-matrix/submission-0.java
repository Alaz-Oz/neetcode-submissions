class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int row = -1;
        // Select row
        while(top <= bottom){
            int mid = top + (bottom - top) / 2;

            if (target >= matrix[mid][left] && target <= matrix[mid][right]){
                row = mid;
                break;
            }
            if (target > matrix[mid][right]){
                top = mid + 1;
            }else{
                bottom = mid - 1;
            }
        }
        if (row == -1) return false;

        // Select column
        while(left <= right){
            int mid = left + (right - left) / 2;

            if (target == matrix[row][mid]){
                return true;
            }
            if (target < matrix[row][mid]) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return false;

    }
}
