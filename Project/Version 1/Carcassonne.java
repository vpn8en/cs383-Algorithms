package carcassonne;

import java.awt.Color;
import java.awt.Image;
import java.util.Scanner;
import edu.princeton.cs.algs4.*;
import javax.swing.ImageIcon;

//import edu.princeton.cs.introcs.StdDraw;

public class Carcassonne {

	public static Tile[] tiles;
	public static Queue playerQueue;
	public static int numPlayers = 0;
	public static final int MAX_PLAYERS = 4; 
	
	public Carcassonne() {
		tiles = new Tile[75];
	}
	public static void main(String[] args) {
		new Carcassonne();
		playerQueue = Player.createPlayers(numPlayers, MAX_PLAYERS);
		Tile.initTiles(tiles);
		startGame();
	}

	private static void startGame() {
		new CarcassonneGUI(playerQueue,tiles);
		while(true){
			//game operations
		}
	}
}
