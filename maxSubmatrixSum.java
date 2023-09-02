public class Solution {
    public long solve(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        long maxSum =Integer.MIN_VALUE;
        //this is suffix matrix
        long[][] pfm = new long[N][M];
        pfm[N-1][M-1]  = A[N-1][M-1];
        maxSum = Math.max(maxSum,pfm[N-1][M-1]);
        //pfm first row submatrix sum
        for(int j=M-2;j>=0;j--){
            pfm[N-1][j]=pfm[N-1][j+1]+A[N-1][j];
            maxSum = Math.max(maxSum,pfm[N-1][j]);
        }
        //first column submatrix sum
        for(int i=N-2;i>=0;i--){
            pfm[i][M-1]=pfm[i+1][M-1]+A[i][M-1];
            maxSum = Math.max(maxSum,pfm[i][M-1]);
            

        }

        for(int i=N-2;i>=0;i--){
            for(int j=M-2;j>=0;j--){
                pfm[i][j] = A[i][j]+pfm[i][j+1]+pfm[i+1][j]-pfm[i+1][j+1];
                maxSum = Math.max(maxSum,pfm[i][j]);



            }
        }
        
        
        return maxSum;
    }
}