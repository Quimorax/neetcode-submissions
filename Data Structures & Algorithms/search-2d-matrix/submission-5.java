class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int rowIndex = -1;
        // searching for row
        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (target >= matrix[middle][0] && target <= matrix[middle][ matrix[middle].length - 1 ]) {
                rowIndex = middle;
                break;
            } else if (target > matrix[middle][ matrix[middle].length - 1 ]) {
                left = middle + 1;
            } else {
                right = middle - 1;  // target < ...
            }
        }
        if (rowIndex == -1) {
            return false;
        }
    
        left = 0;
        right = matrix[rowIndex].length - 1;
        // searching in row
        while (left <= right) {
            int middle = left + ((right - left) / 2);

            if (target == matrix[rowIndex][middle]) {
                return true;
            } else if (target > matrix[rowIndex][middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
