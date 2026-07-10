public class CherryPickup741 {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int t[][][][]=new int[m][n][m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<m;k++){
                    for (int l=0;l<n;l++){
                        t[i][j][k][l]=Integer.MIN_VALUE;
                    }
                }
            }
        }
        // agar ans possible nhi then func me negative ayega so then i should return 0
        int ans=func(0,0,0,0,grid,m,n,t);
        if(ans<0){
            return 0;
        }
        return ans;
    }

    public static int func(int r1,int c1,int r2,int c2,int grid[][],int m,int n,int t[][][][]){
        if (r1>=m||r2>=m||c1>=n||c2>=n||grid[r1][c1]<0||grid[r2][c2]<0){
            return Integer.MIN_VALUE;
        }
        if (r1==m-1&&c1==n-1){
            return grid[r1][c1];
        }
        if (r2==m-1&&c2==n-1){
            return grid[r2][c2];
        }
        if (t[r1][c1][r2][c2]!=Integer.MIN_VALUE){
            return t[r1][c1][r2][c2];
        }
        int curr=0;
        if (r1==r2&&c1==c2){
            curr=grid[r1][c1];
        }else{
            curr=grid[r1][c1]+grid[r2][c2];
        }
        // ab 4 calls  DD,DR,RD,RR
        // and un 4 me se max
        curr+=Math.max(Math.max(func(r1+1,c1,r2+1,c2,grid, m,n,t),func(r1+1,c1,r2,c2+1,grid, m,n,t)),Math.max(func(r1,c1+1,r2+1,c2,grid, m,n,t),func(r1,c1+1,r2,c2+1,grid, m,n,t)));
        return t[r1][c1][r2][c2]=curr;

    }
}
