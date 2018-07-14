class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();
        result.add("");
        for(char cdigit : digits.toCharArray()) {
            LinkedList<String> temp = new LinkedList<>();
            int digit = cdigit - '0';
            for(String str : result) {
                for(char chr : mapping[digit].toCharArray()) {
                    temp.add(str + chr);
                }
            }
            result = temp;
        }
        return result;
    }
}
