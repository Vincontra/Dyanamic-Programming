public class FrogJumpGFG {
    int minCost(int[] height) {
        int n=height.length;
        int arr[]=new int[n];
        for (int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
//        return func(height,arr,n-1);
        return tabulation(height,arr,n);
    }
    public static int func(int height[],int arr[],int n){
        if (n==0){
            return arr[0]=0;
        }
        if (n==1){
            return arr[1]=Math.abs(height[0]-height[1]);
        }
        if (arr[n]!=-1){
            return arr[n];
        }
        return arr[n]=Math.min(Math.abs(height[n]-height[n-1])+func(height,arr,n-1),Math.abs(height[n]-height[n-2])+func(height,arr,n-2));
    }
    public static int tabulation(int height[],int arr[],int n){
        arr[0]=0;
        if (n==1){
            return 0;
        }
        arr[1]=Math.abs(height[0]-height[1]);
        for (int i=2;i<arr.length;i++){
            arr[i]=Math.min(Math.abs(height[i]-height[i-1])+arr[i-1],Math.abs(height[i]-height[i-2])+arr[i-2]);
        }
        return arr[n-1];
    }

}
