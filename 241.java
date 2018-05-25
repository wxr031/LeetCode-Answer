public List<Integer> diffWaysToCompute(String input) {
	List<Integer> list = new ArrayList<>();
	for(int i = 0; i < input.length(); i++) {
		if(Character.isDigit(input.charAt(i))) continue;
		List<Integer> left = diffWaysToCompute(input.substring(0, i));
		List<Integer> right = diffWaysToCompute(input.substring(i + 1));
		switch(input.charAt(i)) {
			case '+': for(int leftNum : left) for(int rightNum : right) list.add(leftNum + rightNum); break;
			case '-': for(int leftNum : left) for(int rightNum : right) list.add(leftNum - rightNum); break;
			case '*': for(int leftNum : left) for(int rightNum : right) list.add(leftNum * rightNum); break;
		}
	}
	if(list.size() == 0) {
		list.add(Integer.valueOf(input));
	}
	return list;
}
