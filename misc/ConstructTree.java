import java.util.*;

// Definition of TreeNode
class Node {
    public long val;
    public Node left;
    public Node right;

    public Node (long x) {
        val = x;
        left = null;
        right = null;
    }
}

public class ConstructTree {

    int preInd;
    Map<Long,Integer> map;

    public Node constructBinaryTreeFromPreorderAndInorderTraversal(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i=0; i<n; i++) {
            map.put((long)preorder[i], i);
        }
        preInd = 0;

        return build(0, n-1, preorder);
    }

    Node build(int s, int e, int[]p) {
        if (s > e) return null;

        long rootVal = p[preInd++];
        Node root = new Node(rootVal);
        int idx = map.get(root.val);

        root.left = build(s, idx-1, p);
        root.right =build(idx+1, e, p);

        return root;
    }
}
