public class Solution {
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int N=A.length;
        int M =A[0].length;
        long[][] pfm = new long[N][M];
        int mod = (int)1e9+7;
        //applying preix sum rowwise
        for(int i=0;i<N;i++){
            pfm[i][0]=(A[i][0]+mod)%mod;
            for(int j=1;j<M;j++){
                pfm[i][j]=(pfm[i][j-1]+A[i][j]+mod)%mod;
               
            }
        }
        //applying prefix sum column wise
        for(int j=0;j<M;j++){
        
            for(int i=1;i<N;i++){
                pfm[i][j]=(pfm[i-1][j]+pfm[i][j]+mod)%mod;
                //  System.out.print("i="+i+"j="+j+"=>"+pfm[i][j]);
            }
        }

        /*submatrix sum i.e  TL and BR is given in 
            (B[i], C[i]) represents the top left corner of the i'th query.
            (D[i], E[i]) represents the bottom right corner of the i'th query.
        */
        int Q=B.length;
        int[] res = new int[Q];
        int k=0;
        for(int i=0;i<Q;i++){
            int x1 = B[i]-1;
            int y1=C[i]-1;
            int x2 = D[i]-1;
            int y2 = E[i]-1;
            long sum=0;
            sum=pfm[x2][y2];
            if(y1>0){
                sum=(sum-pfm[x2][y1-1]+mod)%mod;
            }
            if(x1>0){
                sum=(sum-pfm[x1-1][y2]+mod)%mod;
            }
            if(x1>0 && y1>0){
                sum=(sum+pfm[x1-1][y1-1]+mod)%mod;
            }

            res[k++]=(int)sum;
        }

        return res;

    }
}
