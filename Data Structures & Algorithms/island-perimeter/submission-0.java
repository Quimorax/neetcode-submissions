class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, visited, i, j);
                }
            }
        }
        return perimeter;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        boolean inMatrix = isInBoundaries(grid, i, j);

        if (!inMatrix) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int perimeter = 0;
        perimeter += dfs(grid, visited, i, j + 1);
        perimeter += dfs(grid, visited, i, j - 1);
        perimeter += dfs(grid, visited, i + 1, j);
        perimeter += dfs(grid, visited, i - 1, j);

        return perimeter;
    }

    private boolean isInBoundaries(int[][] grid, int i, int j) {
        int rowAmount = grid.length;
        int columnAmount = grid[0].length;
        return i >= 0 && j >= 0 && i < rowAmount && j < columnAmount;
    }
}