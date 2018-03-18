import java.util.Scanner;

public class PreOrderTraversal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode currentNode, right, left;
        TreeNode root = new TreeNode(1);
        currentNode = root;
        right = new TreeNode(2);
        currentNode.setRight(right);
        currentNode = right;
        right = new TreeNode(5);
        currentNode.setRight(right);
        currentNode = right;
        left = new TreeNode(3);
        currentNode.setLeft(left);
        right = new TreeNode(6);
        currentNode.setRight(right);
        currentNode = currentNode.getLeft();
        right = new TreeNode(4);
        currentNode.setRight(right);
        currentNode = right;

        preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.getLeft());
        System.out.println(root.getValue());
        preOrder(root.getRight());
    }
}
