public class LongestPalindromicSubsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i++){
                sb.append(s.charAt(i));
            }
            String s1=sb.reverse().toString();

            // palindrome matlab similar from l to r and r to l
            // and usme bhi longest subsequence
            // iska matlab normal and reverse wali string ka
            // longest common subsequence
            // common kyu as wahi to part hoga jo palindrome hoga as wo ek hi string hai
            // khali ek normal and ek reverse
            return lcs(s,s1);

        }
        public static int lcs(String s,String s1){
            // tabulation try krte
            // agar char equal hai matlab 1+ further call
            // nhi matlab kya pata future me ho so i as it is j ko piche and j as it i ko piche
            // achaa last se chalu krenge isliye piche
            // start se kra hota then increment
            int t[][]=new int[s.length()+1][s.length()+1];
            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=s.length();j++){
                    if(s.charAt(i-1)==s1.charAt(j-1)){
                        t[i][j]=1+t[i-1][j-1];
                    }
                    else{
                        t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                    }
                }
            }
            return t[s.length()][s.length()];
        }
    }
}
