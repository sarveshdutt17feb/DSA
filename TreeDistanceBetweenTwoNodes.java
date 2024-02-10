
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int distanceFromRoot(TreeNode A,int key){
        if(A.val==key){
            return 0;
        }
        else if(A.val>key){
            return 1+distanceFromRoot(A.left,key);
        }
        return 1+distanceFromRoot(A.right,key);
    }
    public int distanceBetween2(TreeNode A,int B,int C){
        if(A==null){
            return 0;
        }
        if(A.val<B && A.val<C){
            return distanceBetween2(A.right,B,C);
        }
        if(A.val>B && A.val>C){
            return distanceBetween2(A.left,B,C);
        }
        if(A.val>=B && A.val<=C){
            return distanceFromRoot(A,B)+distanceFromRoot(A,C);
        }
        return -1;
    }
    public int solve(TreeNode A, int B, int C) {
        if(B>C){
            int temp =B;
            B=C;
            C=temp;
        }
        return distanceBetween2(A,B,C);
    }
}
