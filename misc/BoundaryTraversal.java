import java.util.*;

/*
// Definition of TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}

Use new TreeNode(data) to create new Node
*/

public class BoundaryTraversal {
    public ArrayList<Long> binaryTreeBoundaryTraversal(TreeNode root){
        int []global = new int[]{-1};
        ArrayList<Long> res = new ArrayList<>();

        leftBoundary(root, res, global, 0);

        return res;
    }

    void inorder(TreeNode root, List<Long> li) {
        if (root == null) return;

        inorder(root.left, li);
        li.add(root.val);
        inorder(root.right, li);
    }

    TreeNode build(int s, int e, List<Long> li) {
        if ( s > e ) return null;

        int mid = (s+e)/2;
        TreeNode root = new TreeNode();

        root.left = build(s, mid-1, li);
        root.right = build(mid+1, e, li);

        return root;
    }

    TreeNode leftMost(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public int inorderSuccessor(TreeNode root,TreeNode givenNode){
        TreeNode succ = successor(root, givenNode.val, null);
        if (succ != null) return (int)succ.val;
        return -1;
    }

    TreeNode successor(TreeNode root, long key, TreeNode succ) {
        if (root == null) {
            succ = null;
            return succ;
        }

        if (key == root.val && root.right != null) {
            succ = leftMost(root.right);
        }else if (key <= root.val) {
            succ = root;
            successor(root.left, key, succ);
        }else {
            successor(root.right, key, succ);
        }

        return succ;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Long> li = new ArrayList<>();

        inorder(root, li);
        return build(0, li.size()-1, li);
    }

    boolean validateBinarySearchTree(TreeNode root) {
        if (root == null) return true;

        boolean left = validateBinarySearchTree(root.left);
        boolean right = validateBinarySearchTree(root.right);

        return ((root.left != null ? root.val >= root.left.val : left) && (root.right != null ? root.val < root.right.val : right));
    }

    void leftBoundary(TreeNode root,ArrayList<Long> res, int []global, int local) {
        if (root == null) return;

        if (local >= global[0]) res.add(root.val);
        global[0] = local;
        local++;

        leftBoundary(root.left, res, global, local);
        leftBoundary(root.right, res, global, local);
    }

    void rightBoundary(TreeNode root,ArrayList<Long> res, int []global, int level) {
        if (root == null) return;

        if (level > global[0]) res.add(root.val);
        if (level == global[0] && root.left == root.right) res.add(root.val);
        global[0] = Math.max(global[0], level);
        level++;

        rightBoundary(root.right, res, global, level);
        level++;
        rightBoundary(root.left, res, global, level);
    }
}
