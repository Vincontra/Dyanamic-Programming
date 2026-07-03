class Solution {
    public static int func(int nums[],int n,int arr[]){
        if(n<0){
            return 0;
        }
        if(arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=Math.max(nums[n]+func(nums,n-2,arr),func(nums,n-1,arr));
    }
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1){
            return nums[0];
        }
        int a[]=new int[n-1];
        int b[]=new int[n-1];
        int idx=0;
        for (int i=0;i<a.length;i++){
            a[i]=nums[idx];
            idx++;
        }
        idx=1;
        for (int i=0;i<b.length;i++){
            b[i]=nums[idx];
            idx++;
        }
        int arr[]=new int[a.length+1];
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        int first=func(a,a.length-1,arr);
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        int second=func(b,b.length-1,arr);
        return Math.max(first,second);

    }
}
