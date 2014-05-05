package a1;
import edu.princeton.cs.introcs.StdDraw;
import java.lang.Math;

public class RandomConnections {

/**
 * PLots N equally spaced dots of size .05 on the circumference of a circle,
 * and then, with probability p for each pair
 * of points , draws a gray line connecting them
 * @param n
 * @param p
 */
	public static void main(String[] args){
		run(17, .25);
	}
	public static void run(int n, double p) {
		// TODO Auto-generated method stub
		double[][] dots = new double[n][2];
		double offset = 0;
		double rad = .5;
		double circx = .5; //x coordinate of the center of the circle
		double circy = .5; //y coordinate of the center of the circle
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.circle(circx, circy, rad);

		for (int i = 0; i < n; i++) {
			dots[i][0] = rad * Math.cos(offset) + circx;
			dots[i][1] = rad * Math.sin(offset) + circy;
			StdDraw.filledCircle(dots[i][0], dots[i][1], .02);//draws each of the dots with a .03 radius 
			offset += (2*Math.PI)/n;
		}
		
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int i = 0; i < dots.length; i++) {
			double[] theDot = dots[i];
			for (int j = 0; j < dots.length; j++) {
				if (Math.random() < p) StdDraw.line(theDot[0], theDot[1], dots[j][0], dots[j][1]);
			}
		}
	}
}
