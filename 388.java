class Solution {
	public int lengthLongestPath(String input) {
		String[] paths = input.split("\n");
		int[] stack = new int[paths.length + 1];
		int result = 0;

        for (String obj : paths) {
            int tabNum = obj.lastIndexOf("\t") + 1;
            stack[tabNum + 1] = stack[tabNum] + obj.length() - tabNum;
            if (obj.indexOf('.') != -1) {
                result = Math.max(result, stack[tabNum + 1] + tabNum);
            }
        }
        return result;
    }
}
