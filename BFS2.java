// Problem 1: https://leetcode.com/problems/binary-tree-right-side-view/
// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We will use DFS to solve this problem. We will traverse the tree in a pre-order manner and keep track of the level of the node. If the level of the node is equal to the size of the result list, then we can say that this is the rightmost node at that level. We will add this node to the result list.
class Solution {
    List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        this.result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == result.size()) {
            result.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}

// Problem 2: https://leetcode.com/problems/cousins-in-binary-tree/
// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We will use BFS to solve this problem. We will keep track of the
// parent of the nodes x and y. If the parent of x and y are not same and the
// depth of x and y are same, then we can say that x and y are cousins.
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x)
                    x_found = true;
                if (curr.val == y)
                    y_found = true;
                if (curr.left != null && curr.right != null) {
                    if (curr.left.val == x && curr.right.val == y)
                        return false;
                    if (curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            if (x_found && y_found)
                return true;
            if (x_found || y_found)
                return false;
        }
        return false;

    }
}