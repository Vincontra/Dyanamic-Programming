public class GeekTraining {
    public int maximumPoints(int mat[][]) {
        int n=mat.length;
        int arr[][]=new int[n+1][4];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<4;j++){
                arr[i][j]=-1;
            }
        }
        return func(mat,n-1,3,arr);
    }
    public static int func(int mat[][],int day,int last,int arr[][]){
        if (day==0){
            // last ko chod kr baki do we have to perform
            int max=Integer.MIN_VALUE;
            // 0 1 2 me se hi koi ek hoga that last
            if (last==0){
                max=Math.max(max,mat[day][1]);
                max=Math.max(max,mat[day][2]);
            }
            else if (last==1){
                max=Math.max(max,mat[day][0]);
                max=Math.max(max,mat[day][2]);
            }else{
                max=Math.max(max,mat[day][0]);
                max=Math.max(max,mat[day][1]);
            }
            return max;
        }
        if (arr[day][last]!=-1){
            return arr[day][last];
        }
        // i need to figure out kisko nhi krna hai

        int max=Integer.MIN_VALUE;
        // 0 1 2 me se hi koi ek hoga that last
        if (last==0){
            max=Math.max(max,mat[day][1]+func(mat,day-1,1,arr));
            max=Math.max(max,mat[day][2]+func(mat,day-1,2,arr));
        }
        else if (last==1){
            max=Math.max(max,mat[day][0]+func(mat,day-1,0,arr));
            max=Math.max(max,mat[day][2]+func(mat,day-1,2,arr));
        }
        else if (last==2){
            max=Math.max(max,mat[day][0]+func(mat,day-1,0,arr));
            max=Math.max(max,mat[day][1]+func(mat,day-1,1,arr));
        }else{
            // pehli baar teno me se we should do as isse se pehle we did not have done any opr
            // right
            max=Math.max(max,mat[day][0]+func(mat,day-1,0,arr));
            max=Math.max(max,mat[day][1]+func(mat,day-1,1,arr));
            max=Math.max(max,mat[day][2]+func(mat,day-1,2,arr));
        }
        return arr[day][last]=max;
    }
}
