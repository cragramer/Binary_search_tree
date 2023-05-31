import java.util.*;

public class BST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        TreeNode root = buildSearchTree(nums);
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        preorderTraversal(root, preorderList);
        postorderTraversal(root, postorderList);

        for (int num : inorderList) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : preorderList) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : postorderList) {
            System.out.print(num + " ");
        }
    }

    public static TreeNode buildSearchTree(int[] nums) {
        TreeNode root = null;
        for (int num : nums) {
            root = insertIntoBST(root, num);
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left, result);
            preorderTraversal(root.right, result);
        }
    }

    public static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            postorderTraversal(root.left, result);
            postorderTraversal(root.right, result);
            result.add(root.val);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
