package a6;

import org.junit.Test;

import edu.princeton.cs.introcs.StdDraw;
import static edu.princeton.cs.introcs.StdDraw.*;

/**
 * These "tests" don't actually include any assertions; they just cause the
 * drawings to be made so that they can be visually inspected.
 */
public class A6Test {

	@Test
	public void testSpaceDisagreement() {
		SpaceDisagreement map = new SpaceDisagreement(100);
		map.draw();
		show(6000);
		StdDraw.clear();
	}

	@Test
	public void testAnimatedPrim() {
		new AnimatedPrim(100);
		show(6000);
	}
}