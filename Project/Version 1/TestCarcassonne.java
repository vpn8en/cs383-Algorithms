package carcassonne;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import a4.Triplicates;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdDraw;


public class TestCarcassonne {
	Queue<Player> testQueue;
	Tile[] testTiles;

	Double [] data;
	@Before
	public void setUp() throws Exception {
		testQueue = new Queue<Player>();
		Player player0 = new Player("Bob",Color.BLACK);
		Player player1 = new Player("Bill",Color.BLACK);
		Player player2 = new Player("Frank",Color.BLACK);
		Player player3 = new Player("Amy",Color.BLACK);

		testQueue.enqueue(player0);
		testQueue.enqueue(player1);
		testQueue.enqueue(player2);
		testQueue.enqueue(player3);

		
		testTiles = new Tile[75];
		Tile.initTiles(testTiles);
	}
	
	
	
	@Test
	public void testPlayer(){
		new Player("Ben", Color.blue);
	}

	@Test
	public void testQueue(){
		assertEquals("Bob", testQueue.dequeue().name);
		assertEquals("Bill", testQueue.dequeue().name);
		assertEquals("Frank", testQueue.dequeue().name);
		assertEquals("Amy", testQueue.dequeue().name);	
	
	}
	@Test
	public void testTiles(){
		for (int i = 0; i < testTiles.length; i++) {
			assertEquals(false, testTiles[i].hasMeeple());
			assertEquals("0tile00.jpg",testTiles[i].getImageFile());//primative testing
		}
	}
	
	@Test
	public void testGUI(){
		new CarcassonneGUI(testQueue,testTiles);
		StdDraw.show(1000);
		}
}
