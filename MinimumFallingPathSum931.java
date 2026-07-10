public class MinimumFallingPathSum931 {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int t[][]=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                t[i][j]=Integer.MAX_VALUE;
            }
        }
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<matrix[0].length;i++){
            ans=Math.min(ans,func(matrix,0,i,t));
        }
        return ans;
    }
    public static int func(int mat[][],int i,int j,int t[][]){
        if(j<0||j==mat[0].length){
            return Integer.MAX_VALUE;
            // not possible so i returned that cant be answer
            // or that should not be answer
        }
        if(i==mat.length){
            // successfully reach till last row
            // so return 0
            // since we are at last row+1
            return 0;
        }
        if (t[i][j]!=Integer.MAX_VALUE){
            return t[i][j];
        }
        int mid=func(mat,i+1,j,t);
        int left=func(mat,i+1,j-1,t);
        int right=func(mat,i+1,j+1,t);
        return t[i][j]=mat[i][j]+Math.min(mid,Math.min(left, right));
    }
}
