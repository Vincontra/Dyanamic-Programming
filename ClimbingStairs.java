import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner v=new Scanner(System.in);
        int n=v.nextInt();
        int arr[]=new int[n+2];
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        func(arr,n+1);
        System.out.println(arr[n+1]);

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

    // Try to think that problem as :
    // try to index that problem
    // then on that index apply what we have to find
    // then if count then sum all possible ways
    // if min find min among all possible ways
    // likewise it completely depends upon the question



}
