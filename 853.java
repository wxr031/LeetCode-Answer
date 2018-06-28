import java.util.*;

class Solution {
	public static int carFleet(int target, int[] position, int[] speed) {
		TreeMap<Integer, Double> map = new TreeMap<>();
		for(int i = 0; i < position.length; i++) {
			map.put(-position[i], (double)(target - position[i]) / speed[i]);
		}
		double currTime = Double.MIN_VALUE;
		int fleet = 0;
		for(Map.Entry<Integer, Double> entry : map.entrySet()) {
			if(entry.getValue() > currTime) {
				currTime = entry.getValue();
				fleet++;
			}
		}
		return fleet;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		int num = scanner.nextInt();
		int[] position = new int[num], speed = new int[num];
		for(int i = 0; i < num; i++) {
			position[i] = scanner.nextInt();
		}
		for(int i = 0; i < num; i++) {
			speed[i] = scanner.nextInt();
		}
		System.out.println(carFleet(target, position, speed));
	}
}
