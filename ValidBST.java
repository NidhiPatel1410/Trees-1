// In this we are doing inorder traversal and at any given point of time we are just comparing the previous node value with current 
// node value, if the previous is greater than or equal then it is not a valid BST. 

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Recursive implementation of in-order traversal
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        inorder(root);
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}

// Iterative implementation of in-order traversal
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            System.out.println(root.val);
            root = root.right;

        }
        return true;
    }
}

// Solution for actual problem - recursive - with prev in global scope
class Solution2 {
    TreeNode prev;
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root);
        return isValid;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}

// Solution for actual problem - recursive - with prev in local scope - this
// will not work - for reason refer notes
class Solution2 {
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        inorder(root, null);
        return isValid;
    }

    private void inorder(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        inorder(root.left, prev);
        if (prev != null && prev.val >= root.val) {
            isValid = false;
            return;
        }
        prev = root;
        inorder(root.right, prev);
    }
}

// Solution for actual problem - iterative - with prev in global scope
class Solution3 {
    TreeNode prev;
    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return isValid;
    }
}

// Solution for actual problem - iterative - with prev in local scope
class Solution3 {

    Boolean isValid;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        isValid = true;
        TreeNode prev = null;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (prev != null && prev.val >= root.val) {
                isValid = false;
                break;
            }
            prev = root;
            root = root.right;
        }
        return isValid;
    }
}