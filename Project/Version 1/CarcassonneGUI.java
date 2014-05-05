package carcassonne;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdDraw;


public class CarcassonneGUI{

    public static final int BOARD_WIDTH = 550;
    public static final int BOARD_HEIGHT = 500;
    public static final int WIDTH = BOARD_WIDTH + 300;
    public static final int HEIGHT = BOARD_HEIGHT + 50;
    public static final int BORDER = 25;


    public CarcassonneGUI(Queue<Player> playerQueue, Tile[] tiles) {
        StdDraw.setCanvasSize(WIDTH,HEIGHT);
    	StdDraw.setYscale(0,HEIGHT);
    	StdDraw.setXscale(0,WIDTH);
    	StdDraw.text((2*BORDER + BOARD_WIDTH)/2, HEIGHT-(BORDER/2), "Carcassone");
    	int i = BORDER;
    	for (Player p : playerQueue) {
    	StdDraw.text((3*BORDER + BOARD_WIDTH), HEIGHT-(i), p.name);
    	i+= 2*BORDER;
    	}
    	paintBoard();
    	//showTiles(tiles);
    }


    private void paintBoard() {
    	StdDraw.setPenRadius(.005);
    	StdDraw.line(BORDER,BORDER,BORDER,BORDER+BOARD_HEIGHT);
    	StdDraw.line(BOARD_WIDTH+BORDER,BORDER,BOARD_WIDTH+BORDER,BOARD_HEIGHT+BORDER);
    	StdDraw.line(BORDER,BORDER+BOARD_HEIGHT,BOARD_WIDTH+BORDER,BOARD_HEIGHT+BORDER);
    	StdDraw.line(BORDER,BORDER,BOARD_WIDTH+BORDER,BORDER);
    	StdDraw.setPenRadius(.002);
    	for (int i = BORDER; i < BOARD_WIDTH+BORDER ; i+=50) {
			StdDraw.line(i,BORDER+BOARD_HEIGHT,i,BORDER);
			StdDraw.line(BORDER+BOARD_WIDTH,i,BORDER,i);
		}
	}
    
    private void showTiles(Tile[] tiles){//THIS METHOD IS CURRENTLY BEING FIXED
    	int counter = 0;
    	for (int i = BORDER; i < BOARD_WIDTH+BORDER ; i+=50) {
    		StdDraw.picture(BORDER, BORDER, tiles[counter].getImageFile());
    		counter++;
    	}
    }
}
