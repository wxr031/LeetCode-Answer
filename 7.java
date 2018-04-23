class Solution {
    public int reverse(int number) {
        if(number == 0) return 0;
		long result = 0;
		while(number != 0) {
			long newResult = result * 10 + number % 10;
			if(newResult > Integer.MAX_VALUE || newResult < Integer.MIN_VALUE)
				return 0;
			result = newResult;
			number /= 10;
		}
		return (int)result;
	}
}
