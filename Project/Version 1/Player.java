package carcassonne;

import java.awt.Color;
import java.util.Scanner;

import edu.princeton.cs.algs4.Queue;

public class Player {

	public Meeple[] meeples = new Meeple[5];
	public String name;
	public Color color;
	
	public Player(String name, Color color ){
		this.name = name;
		this.color = color;
	}
	
	static Queue createPlayers(int numPlayers, int MAX_PLAYERS) {//find players names, and create them
		Queue<Player> playerQueue = new Queue<Player>();
		Scanner s = new Scanner(System.in);
		while((numPlayers == 0)||(numPlayers > MAX_PLAYERS)){
		System.out.println("Welcome to Carcassonne! Please enter the number of players. (Must be less than 5).");
		numPlayers = Integer.parseInt(s.nextLine());
		}
		String name;
		Color color = Color.BLACK;//temporary
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Please Enter Player"+i+"'s Name.");
			name = s.nextLine().trim();
			Player player = new Player(name,color);
			playerQueue.enqueue(player);
		}
		return playerQueue;
	}

	public Meeple[] getMeeples() {
		return meeples;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
