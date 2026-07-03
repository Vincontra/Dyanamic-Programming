public class FrogJumpWithK_Jumps {
    public static void main(String[] args) {

    }
    int minCost(int[] height,int k) {
        int n=height.length;
        int arr[]=new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        return func(height,arr,n-1,k);
    }
    public static int func(int height[],int arr[],int n,int k) {
        if (n == 0) {
            return arr[0] = 0;
        }
        if (arr[n]!=-1){
            return arr[n];
        }
        int min=Integer.MAX_VALUE;
        for (int i=1;i<=k;i++){
            if (n-i>=0){
                int curr=func(height,arr,n-i,k)+Math.abs(height[n]-height[n-i]);
                min= Math.min(min,curr);
            }
        }
        return arr[n]=min;
    }

}
