public class LongestCommonSubstring {
    class Solution {
        public int longCommSubstr(String s1, String s2) {
            int m=s1.length();
            int n=s2.length();
            int t[][]=new int[m+1][n+1];
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    t[i][j]=-1;
                }
            }
            int ans=0;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    ans=Math.max(ans,func(s1,s2,t,i,j));
                }
            }
            return ans;

        }
        public static int func(String s1,String s2,int t[][],int i,int j){
            if(i==0||j==0){
                return 0;
            }
            if(t[i][j]!=-1){
                return t[i][j];
            }

            if(s1.charAt(i-1)==s2.charAt(j-1)){
                return t[i][j]=1+func(s1,s2,t,i-1,j-1);
            }else{
                return t[i][j]=0;
            }
        }
    }

}
