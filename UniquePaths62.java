import java.util.*;
public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int i=m-1;
        int j=n-1;
        HashMap<String,Integer>hm=new HashMap<>();
        return func(i,j,hm);
    }
    public static int func(int i,int j, HashMap<String,Integer>hm){

        if(i<0||j<0){
            return 0; // this is basically in valid or we are going outside the grid
        }
        if(i==0||j==0){
            return 1;
        }
        String curr=i+" "+j;
        // what if these cordinates are already visited then
        if(hm.containsKey(curr)){
            return hm.get(curr);
        }
        int cnt=func(i-1,j,hm)+func(i,j-1,hm);
        hm.put(curr,cnt);
        return cnt;

    }
}
// another way
//class Solution {
//    public int uniquePaths(int m, int n) {
//        int t[][]=new int[m+1][n+1];
//        for(int i=0;i<=m;i++){
//            for(int j=0;j<=n;j++){
//                t[i][j]=-1;
//            }
//        }
//        return func(m-1,n-1,t);
//    }
//    public static int func(int i,int j,int t[][]){
//        if(i<0||j<0){
//            return 0;
//        }
//        if(i==0||j==0){
//            return 1;
//        }
//        if(t[i][j]!=-1){
//            return t[i][j];
//        }
//        return t[i][j]=func(i-1,j,t)+func(i,j-1,t);
//
//    }
//}
