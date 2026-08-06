public class PrintLCSubseq {
    public static void main(String[] args) {
        String t1="AGGTAB";
        String t2="GXTXAYB";
        // ans is ADH len is 3

        // pehle to try krte ki length kya hogi
        int m=t1.length();
        int n=t2.length();
        int t[][]=new int[m+1][n+1];
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
        StringBuilder sb=new StringBuilder();

        // abhi jo bhi max length hai that is stored at t[m][n]
        // that means whatever lcs is whose length is stored at t[m][n]
        // has that pos as its last char and we do not that where the first char may exist

        // so we will try to go from bottom to top
        // while doing so if char are equal that means we should add it to our ans
        // if not then we should move to the max side
        // ok why max
        // reason is simple while building that table when char are not equal we call to max keeping 1 char same at the moment
        // like i-1 j or i j-1
        // likewise we got the max ans which is len only from that path where that max comes from so
        // if our ans len comes from that direction we should go to max wala part

        // at last reverse as we go from bot to top
        int i=m;
        int j=n;
        while (i>0&&j>0){
            if (t1.charAt(i-1)==t2.charAt(j-1)){
                sb.append(t1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if (t[i][j-1]>t[i-1][j]){
                    j--;
                }else{
                    i--;
                }
            }
        }
        System.out.println(sb.reverse());
    }
}
