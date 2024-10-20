//Time Complexity: O(n)
//Space Conplexity: O(1)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//DFS

class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }
    private void dfs(TreeNode root, int level)
    {
        List<Integer> innerList;
        if(root==null) return;
        
        if(list.size()==level)
        {
            innerList = new ArrayList<>();
            
            list.add(innerList);
        }
        else
        {
            innerList = list.get(level);
        }
        innerList.add(root.val);
        if(root.left!=null) dfs(root.left,level+1);
        if(root.right!=null) dfs(root.right,level+1);
    }
    
}
////////////////
//BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> babyList = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                babyList.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            list.add(babyList);
            
        }
        return list;
    }
}
