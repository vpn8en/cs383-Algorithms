package a6;

import java.awt.Color;
import java.awt.Font;

import a6.AnimatedPrim.Star;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.algs4.Graph;

public class SpaceDisagreement {

	private Star[] stars;
	private Graph graph;

	public static final int XSCALE = 1;
	public static final int YSCALE = 1;

	public SpaceDisagreement(int i) {
		// TODO Auto-generated constructor stub
		stars = new Star[i];
		for (int j = 0; j < i; j++) {
			stars[j] = new Star(StdRandom.uniform(), StdRandom.uniform());
		}
		graph = Star.makeGraph(stars);
	}

	static class Star {// Two stars should have a wormhole (edge) between them
						// if their Euclidean distance is less than 0.15.
		double x;
		double y;

		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public static boolean wormhole(Star a, Star b) {
			return distance(a, b) <= .15;
		}

		public static Graph makeGraph(Star[] stars) {// put stars into a graph
														// and add edges if
														// Euclidean distance is
														// less then .15
			Graph graph = new Graph(stars.length);// make graph of stars.length
													// verticies
			for (int i = 0; i < stars.length; i++) {// add edges
				for (int j = i; j < stars.length; j++) {
					if (wormhole(stars[i], stars[j])) {
						graph.addEdge(i, j);
					}
				}
			}
			return graph;
		}

		private static double distance(Star star, Star star2) {
			return Math.sqrt((star.x - star2.x) * (star.x - star2.x)
					+ (star.y - star2.y) * (star.y - star2.y));
		}
	}

	public void draw() {
		Biconnected bgraph = new Biconnected(graph);
		StdDraw.setXscale(0, XSCALE);
		StdDraw.setYscale(0, YSCALE);
		Font f = new Font("SansSerif",0,8);
		StdDraw.setFont(f);
		StdDraw.show(0);

		for (int i = 0; i < stars.length; i++) {
			// iterate though the stars' neighbors and draw the edge.
			for (int j = i; j < stars.length; j++) {
				StdDraw.setPenRadius(.002);
				StdDraw.setPenColor(Color.BLACK);
				if (Star.wormhole(stars[i], stars[j])) {
					StdDraw.line(stars[i].x, stars[i].y, stars[j].x, stars[j].y);
				}
			}
			StdDraw.setPenRadius(.027);
			StdDraw.setPenColor(Color.gray);
			StdDraw.point(stars[i].x, stars[i].y);
			StdDraw.setPenRadius(.002);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.circle(stars[i].x, stars[i].y, .015);
			StdDraw.text(stars[i].x, stars[i].y, ""+i);
		}
		for (int j = 0; j < stars.length; j++) {
			if (bgraph.isArticulation(j)) {
				StdDraw.setPenRadius(.027);
				StdDraw.setPenColor(Color.RED);
				StdDraw.point(stars[j].x, stars[j].y);
				StdDraw.setPenRadius(.002);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.circle(stars[j].x, stars[j].y, .015);
				StdDraw.text(stars[j].x, stars[j].y, ""+j);

			}
		}
	}
}