class Solution {

	double xCenter, yCenter, radius;
	public Solution(double radius, double xCenter, double yCenter) {
		this.xCenter = xCenter;
		this.yCenter = yCenter;
		this.radius = radius;
	}

	public double[] randPoint() {
		double r = Math.sqrt(Math.random()) * radius;
		double theta = Math.random() * Math.PI * 2.0;
		return new double[] {xCenter + r * Math.cos(theta), yCenter + r * Math.sin(theta)};
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
