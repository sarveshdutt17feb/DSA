public class Solution {
    public int solve(int[] A, int B) {
        int N=A.length;
        int k=0;
        for(int i=0;i<N;i++){
            if(A[i]<=B)
                k++;
        }
       
        int bad=0;
        /*for no.of swaps we minimum no of swaps we need to find a window 
        where bad ele should be less*/
        for(int j=0;j<k;j++){
            if(A[j]>B)
                bad++;
        }
         int ans = bad;
        int s=1;
        int e=k;
        while(e<N){
            if(A[s-1]>B)
                bad--;
            if(A[e]>B)
                bad++;
            if(bad<ans)
                ans=bad;
            s++;
            e++;
        }
        return ans;
    }
}
