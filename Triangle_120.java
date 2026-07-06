import java.util.*;
public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int t[][]=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                t[i][j]=Integer.MAX_VALUE;
            }
        }
        return func(t,triangle,0,0);
    }
    public static int func(int t[][],List<List<Integer>> triangle,int row,int col){
        if (row==triangle.size()||col==triangle.size()){
            return 0;
        }
        if (t[row][col]!=Integer.MAX_VALUE){
            return t[row][col];
        }
        return t[row][col]=triangle.get(row).get(col)+Math.min(func(t,triangle, row+1,col),func(t,triangle,row+1,col+1));
    }
}
