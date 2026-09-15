class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        solve(root, targetSum, path, result);

        return result;
    }

    void solve(TreeNode root, int target, List<Integer> path,
               List<List<Integer>> result) {

        if (root == null) {
            return;
        }

        path.add(root.val);
        target -= root.val;

        if (root.left == null && root.right == null && target == 0) {
            result.add(new ArrayList<>(path));
        }

        solve(root.left, target, path, result);
        solve(root.right, target, path, result);

        path.remove(path.size() - 1);
    }
}