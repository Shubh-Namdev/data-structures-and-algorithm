import java.util.*;

class TreeNode{
    long val;
    TreeNode left;
    TreeNode right;

    TreeNode() {};
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair {
    TreeNode key;
    long value;

    Pair(TreeNode node, long value) {
        this.key = node;
        this.value = value;
    }
}

public class TreeProblems {
    public static void main(String[] args) {

    }

    public ArrayList<Long> topViewBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        Map<Long,Long> map = new HashMap<>();
        long minLevel = Long.MAX_VALUE;
        long maxLevel = Long.MIN_VALUE;

        while (!q.isEmpty()) {
            Pair pair = q.remove();

            TreeNode node = pair.key;
            long level = pair.value;

            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            if (!map.containsKey(level))
                map.put(level, node.val);
            if (node.left != null)
                q.add(new Pair(node.left, level-1));
            if (node.right != null)
                q.add(new Pair(node.right, level+1));
        }

        ArrayList<Long> res = new ArrayList<>();
        for (long i=minLevel; i<=maxLevel; i++) {
            res.add(map.get(i));
        }

        return res;
    }
    void postorder(TreeNode root, long []arr) {
        if (root == null) return;

        //postorder(root.right);
        //postorder(root.left);
        arr[0]--;
        if (arr[0] == 0L){
            arr[1] = root.val;
        }
    }


    boolean checkBalanced(TreeNode root) {
        return isBalanced(root)[0] == 1;
    }

    static int[] isBalanced(TreeNode root) {
        if (root == null)
            return new int[]{1, 0};

        int []left = isBalanced(root.left);
        int []right = isBalanced(root.right);

        if (left[0] == 1 && right[0] == 1) {
            int heightDiff = Math.abs(left[1]-right[1]);
            if (heightDiff <= 1)
                return new int[]{1, Math.max(left[1], right[1])+1};
        }

        return new int[]{0, Math.max(left[1], right[1])+1};
    }

    public long kthLargestElementInABst(TreeNode root, int k) {
        long []arr = new long[2];
        arr[0] = k;

        return arr[1];
    }


    public ArrayList<Long> topViewBinaryTreeOther(TreeNode root) {
        if (root == null) return new ArrayList<>();

        LinkedList<Long> list = new LinkedList<>();

        HashMap<Long,TreeNode> map = new HashMap<>();
        map.put(0L, root);
        HashSet<Long> set = new HashSet<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Pair pair = q.remove();

                TreeNode node = pair.key;
                if (map.containsKey(pair.value) && !set.contains(pair.value)) {
                    if (pair.value < 0) {
                        list.addFirst(map.get(pair.value).val);
                    }else {
                        list.addLast(map.get(pair.value).val);
                    }
                    set.add(pair.value);
                }

                if (node.left != null) {
                    if (!map.containsKey(pair.value - 1)) {
                        map.put(pair.value-1, node.left);
                    }
                    q.add(new Pair(node.left,pair.value-1));
                }
                if (node.right != null) {
                    if (!map.containsKey(pair.value + 1)) {
                        map.put(pair.value+1, node.right);
                    }
                    q.add(new Pair(node.right,pair.value+1));
                }
            }
        }

        /*
        ArrayList<Long> li = new ArrayList<>();
        for (Map.Entry<Long,TreeNode> entry : map.entrySet()) {
            li.add(entry.getKey());
        }

        Collections.sort(li);


        for (long val : li) {
            res.add(map.get(val).val);
        }
        */


        return new ArrayList<>(list);
    }

    public List<Long> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Long> left = inorderTraversal(root.left);
        left.add(root.val);
        List<Long> right = inorderTraversal(root.right);
        left.addAll(right);

        return left;
    }

    public ArrayList<Long> rightViewBinaryTree(TreeNode root) {
        return findNodes(root,new ArrayList<>(),new int[]{0},1);
    }

    public List<List<Long>> zigzagLevelOrder(TreeNode root) {
        List<List<Long>> ans = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int level = 1;

        while (!qu.isEmpty()) {
            List<Long> in = new ArrayList<>();
            int sz = qu.size();
            for (int i=0; i<sz; i++) {
                TreeNode node = qu.remove();

                if (node.left != null) qu.add(node.left);
                if (node.right != null) qu.add(node.right);

                in.add(node.val);
            }
            if (level % 2 == 0) Collections.reverse(in);
            ans.add(in);
            level++;
        }
        return ans;
    }

    static ArrayList<Long> findNodes(TreeNode root, ArrayList<Long> li, int []p, int c) {
        if (root == null) return li;
        Queue<Integer> q = new LinkedList<>();


        if (c > p[0]) {
            li.add(root.val);
            p[0] = c;
            c += 1;
        }
        findNodes(root.right,li,p,c);
        findNodes(root.left,li,p,c);

        return li;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val+"");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) return;

        preOrder(root.left);
        System.out.print(root.val+"");
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.val+"");
    }
}
