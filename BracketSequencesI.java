import java.util.Scanner;
public class BracketSequencesI {
    static final long MOD = 1000000007L;
    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        int n = v.nextInt();
        if (n % 2 == 1) {
            System.out.println(0);
        }
        else{
            System.out.println(cat(n / 2));
        }
    }
    public static long cat(int n) {
        long[] fact = new long[2 * n + 1];
        fact[0]=1;
        for (int i = 1; i <= 2 * n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        long ans = fact[2 * n];
        // divide by n!
        ans = ans * power(fact[n], MOD - 2) % MOD;
        // divide by n!
        ans = ans * power(fact[n], MOD - 2) % MOD;
        // divide by (n + 1)
        ans = ans * power(n + 1, MOD - 2) % MOD;
        return ans;
    }
    public static long power(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b /= 2;
        }
        return ans;
    }
}