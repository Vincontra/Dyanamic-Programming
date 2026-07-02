import java.util.Scanner;

public class Fibonacii {
    public  static void main(String[] args) {
        Scanner v=new Scanner(System.in);
        int n=v.nextInt();
        int arr[]=new int[n+1];
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        //func(arr,n); // memoize
        func1(arr,n);  // tabulation

        for (int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static int func(int arr[],int n){
        if (n==0){
            return arr[n]=0;
        }
        if (n==1){
            return arr[n]=1;
        }
        if (arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=func(arr,n-1)+func(arr,n-2);
    }
    public static void func1(int arr[],int n){
        arr[0]=0;
        arr[1]=1;
        for (int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
    }
}
