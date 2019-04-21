/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(",");
		sb.append(String.valueOf(root.val));
		sb.append(serialize(root.left));
		sb.append(serialize(root.right));
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
        String[] valueStr = data.split(",");
		int[] value = new int[valueStr.length - 1];
		for (int i = 1; i < valueStr.length; i++) {
			value[i - 1] = Integer.parseInt(valueStr[i]);
		}
		return deserialize(value, 0, value.length);
	}
	private TreeNode deserialize(int[] value, int left, int right) {
        if (left == right) {
            return null;
        }
        int mid;
        for (mid = left + 1; mid < right; mid++) {
            if (value[mid] > value[left]) {
                break;
			}
		}
        TreeNode node = new TreeNode(value[left]);
        node.left = deserialize(value, left + 1, mid);
		node.right = deserialize(value, mid, right);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
