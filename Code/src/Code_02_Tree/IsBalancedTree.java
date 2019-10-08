package Code_02_Tree;

/**
 * @ClassName IsBalancedTree
 * @Description 判断一个树是否是一个平衡二叉树
 * 左右两个子树的高度差的绝对值不超过1，并且左右两个子树都具有一个平衡二叉树
 * 满足条件：1.左子树
 *           2.右子树
 *           3.左子树高
 *           4.右子树高
 * @Author ZhangLei
 * @Date 2019/10/8 20:18
 * @Version 1.0
 **/
public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head, 1, res);
        return res[0];
    }

    public static int getHeight(Node head, int level, boolean[] res) {
        if (head == null) {
            return level;
        }
        int lH = getHeight(head.left, level + 1, res);
        if (!res[0]) {
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if (!res[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            res[0] = false;
        }
        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }

}
