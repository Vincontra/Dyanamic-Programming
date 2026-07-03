import java.util.Scanner;
public class MaxSumOfNonAdjEle {

    // this is nothing but House Robber 1
    public int rob(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
       // return func(nums,n-1,arr); // this is top down with memo
        //return arr[n];
        func1(nums,arr);
        return arr[n];
    }
    public static int func(int nums[],int n,int arr[]){
        if(n<0){
            return 0;
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=Math.max(nums[n]+func(nums,n-2,arr),func(nums,n-1,arr));
    }
    public static void func1(int nums[],int arr[]){
        arr[0]=0;
        arr[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            arr[i]=Math.max(arr[i-1],arr[i-2]+nums[i-1]);
        }
    }
}
