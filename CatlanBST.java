public class CatlanBST {
    class Solution {
        public int numTrees(int n) {
            //catlan ka concept as it is
            int t[]=new int[n+1];
            for(int i=0;i<=n;i++){
                t[i]=-1;
            }
            // base case:
            t[0]=1;
            t[1]=1;
            return func(n,t);
        }
        public static int func(int n,int t[]){
            if(n==0||n==1)return 1;
            int currans=0;
            for(int i=0;i<n;i++){
                currans+=func(i,t)*func(n-1-i,t);
            }
            return t[n]=currans;

        }
    }
}
