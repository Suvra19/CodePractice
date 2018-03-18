import sun.reflect.generics.tree.Tree;

import java.util.*;

public class WireRemovalSol {

    /*
    https://www.hackerrank.com/contests/hourrank-24/challenges/wire-removal/problem
    */

    private static double result = 0;
    private static List<TreeNode> children = new ArrayList<>();

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        TreeNode rootNode = null;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n-1; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            TreeNode node1;
            TreeNode node2;
            if (nodeMap.containsKey(x)) {
                node1 = nodeMap.get(x);
            } else {
                node1 = new TreeNode(x);
                nodeMap.put(x, node1);
                if (a0 == 0) {
                    rootNode = node1;
                }
            }
            if (nodeMap.containsKey(y)) {
                node2 = nodeMap.get(y);
            } else {
                node2 = new TreeNode(y);
                nodeMap.put(y, node2);

            }
            if (node1.left == null) {
                node1.left = node2;
            } else {
                node1.right = node2;
            }
        }

        if (n == 3) {
            System.out.println(2);
        } else if (n == 2) {
            System.out.println(1);
        } else {
            double probability = -0.1;
            System.out.println(traverse(rootNode, probability, n));
        }


        in.close();
    }

    private static double traverse(TreeNode root, double probability, int vertices) {
        if (root != null) {
            probability += 0.1;
            if (probability > 0.0) {
                children.clear();
                result += probability * (vertices - calcCasualties(root));
            }
            traverse(root.left, probability, vertices);
            traverse(root.right, probability, vertices);
        }
        return result;
    }

    private static int calcCasualties(TreeNode root) {
        if (root != null) {
            children.add(root);
            calcCasualties(root.left);
            calcCasualties(root.right);
        }
        return children.size();
    }
}
