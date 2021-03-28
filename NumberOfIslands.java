/*
    Number Of Islands:

    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

class Solution {
    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        // number of islands result
        int numOfIslands = 0;
        
        // get the size of the matrix
        // n is the # of rows
        n = grid.length;
        if(n == 0){
            return 0;
        }
        // m is the # of columns
        m = grid[0].length;
        
        // itertate through the matrix and use DFS when we see a '1'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // when we hit a '1', check to see if it's a corner or if the element is water
                if(grid[i][j] == '1'){
                    // check to see if we're out of bounds like in case of corner edges or on a '0', skipping dfs for that element
                    sink(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    // method to check is we're out of bounds or on a '0'
        private void sink(char[][] grid, int i, int j){
            // check
            if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1'){
                return;
            }
            
            // flips to 0 so we can check if there are any surrounding 1's, and we dont check again.
            grid[i][j] = 0;
            
            // all the possible paths we can DFS to from here
            sink(grid, i + 1, j);
            sink(grid, i - 1, j);
            sink(grid, i, j + 1);
            sink(grid, i, j - 1);
        }
}