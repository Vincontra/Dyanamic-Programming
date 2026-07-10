public class CherryPick2 {
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        // Dono robot ki row will always equal as hamesha niche hi jana hai
        // So keep it same
        // hence only 3 states not 4
        // lekin 4 me bhi kra to ans will be correct only

        int t[][][]=new int[m][n][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    t[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        int ans=func(0,0,n-1,m,n,grid,t);
        if(ans<0){
            return 0;
        }
        return ans;

    }
    public static int func(int r,int c1,int c2,int m,int n,int grid[][],int t[][][]){
        if (r>=m||c1<0||c1>=n||c2<0||c2>=n){
            return Integer.MIN_VALUE;
        }
        // Last row
        // Collect cherries.
        // If both robots are on the same cell,
        // count that cherry only once.
        if (r==m-1){
            if (c1==c2){
                return  grid[r][c1];
            }
            return grid[r][c1]+grid[r][c2];
        }
        if (t[r][c1][c2]!=Integer.MIN_VALUE){
            return t[r][c1][c2];
        }
        int curr=0;
        if (c1==c2){
            curr=grid[r][c1];
        }else{
            curr=grid[r][c1]+grid[r][c2];
        }
        // now 9 calls
        // Robot1 has 3 choices:
        // left diagonal, down, right diagonal.
        // Robot2 also has 3 choices.
        // tot transitions=3*3=9.
        // Among all 9 ways
        // max cherries ko lenge
        int max=Integer.MIN_VALUE;
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){// this part is the way to call 9 ways instead of huge code; copied this part only ; but my logic is correct
                max=Math.max(max,func(r+1,c1+i,c2+j,m,n,grid,t));
            }
        }
        curr+=max;
        return t[r][c1][c2]=curr;
    }
}
