/*
    Maximal Square:

    Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        // stores the largest square area
        int largestSquare = 0;
        
        // get the size of the matrix
        // n is the # of rows
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        
        // m is the # of columns
        int m = matrix[0].length;
        
        // recursive DP
        int[][] dp = new int[n][m];
        
        // iterate through the matrix and use DFS when we see a '1'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';
                    largestSquare = Math.max(largestSquare, dp[i][j]);
                }
                else if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    largestSquare = Math.max(largestSquare, dp[i][j]);
                }
            }
        }
        return largestSquare * largestSquare;
    }
    
}