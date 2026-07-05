public class MinimumPathSum64 {
    class Solution {
        public int minPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int t[][]=new int[m+1][n+1];
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    t[i][j]=-1;
                }
            }
            return func(grid,m-1,n-1,t);
        }
        public static int func(int grid[][],int i,int j,int t[][]){
            if (i<0||j<0){
                return Integer.MAX_VALUE;
            }
            if (i==0&&j==0){
                return grid[i][j];
            }
            if (t[i][j]!=-1){
                return t[i][j];
            }
            return t[i][j]=grid[i][j]+Math.min(func(grid,i-1,j,t),func(grid,i,j-1,t));
        }
    }
}
