class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		int radius = 0;
		for(int i = 0, j = 0; i < houses.length; i++) {
			while(j < heaters.length && heaters[j] < houses[i]) {
				j++;
			}
			if(j == 0) {
				radius = Math.max(radius, heaters[j] - houses[i]);
			}
			else if(j == heaters.length) {
				radius = Math.max(radius, houses[i] - heaters[j - 1]);
			}
			else {
				radius = Math.max(radius, Math.min(houses[i] - heaters[j - 1], heaters[j] - houses[i]));
			}
		}
		return radius;
	}
}
