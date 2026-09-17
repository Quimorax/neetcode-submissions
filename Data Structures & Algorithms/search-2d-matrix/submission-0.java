class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastIndex = matrix[0].length - 1;
        int rowIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (target == matrix[i][lastIndex]) {
                return true;
            }
            if (target < matrix[i][lastIndex]) {
                rowIndex = i;
                break;
            }
        }

        int left = 0;
        int right = matrix[rowIndex].length - 1;

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
