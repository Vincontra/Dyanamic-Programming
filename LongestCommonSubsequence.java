public class LongestCommonSubsequence {
    class Solution {
        public int longestCommonSubsequence(String t1, String t2){
            int m=t1.length();
            int n=t2.length();
            int t[][]=new int[m+1][n+1];
//            for(int i=0;i<=m;i++){
//                for(int j=0;j<=n;j++){
//                    t[i][j]=-1;
//                }
//            }
//            return func(t,t1,t2,m,n);

            // tabulation
            for (int i=1;i<=m;i++){
                for (int j=1;j<=n;j++){
                    if(t1.charAt(i-1)==t2.charAt(j-1)){
                        t[i][j]=1+t[i-1][j-1];
                    }
                    else{
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                    }
                }
            }
            return t[t1.length()][t2.length()];

        }
        public static int func(int t[][],String t1,String t2,int m,int n){
            if(m==0||n==0){
                return 0;  // koi char hai hi nhi to comapare kisko karna
            }
            if(t[m][n]!=-1){
                return t[m][n]; //
            }

            if(t1.charAt(m-1)==t2.charAt(n-1)){
                return t[m][n]=1+func(t,t1,t2,m-1,n-1);
            }
            else{
                return t[m][n]=Math.max(func(t,t1,t2,m,n-1),func(t,t1,t2,m-1,n));
            }
        }
    }
}
