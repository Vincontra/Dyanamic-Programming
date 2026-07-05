public class UniquePathsII63 {
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int t[][]=new int[m+1][n+1];
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    t[i][j]=-1;
                }
            }
            if (obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1){
                return 0;
            }
            return func(m-1,n-1,t,obstacleGrid);
        }

        public static int func(int i,int j,int t[][],int[][]obstacleGrid){
            if(i<0||j<0){
                return 0;
            }
            if (obstacleGrid[i][j]==1){
                return 0;
            }
            if(i==0&&j==0){
                return 1;
            }
            if(t[i][j]!=-1){
                return t[i][j];
            }
            return t[i][j]=func(i-1,j,t,obstacleGrid)+func(i,j-1,t,obstacleGrid);
        }
    }

}
