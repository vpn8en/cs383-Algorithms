package carcassonne;

public class Tile {
	
	private String imageString;
	private boolean hasMeeple = false;
	private boolean beenPlayed = false;
	private int meepleLocation;
	private Meeple meeple;
	private int[][] location;
	
	public Tile(){
		
	}

	public static void initTiles(Tile[] tiles) {	
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
			tiles[i].imageString = "0tile00.jpg";
		}
	}

	public boolean hasMeeple() {
		return hasMeeple;
	}

	public void setHasMeeple(boolean hasMeeple) {
		this.hasMeeple = hasMeeple;
	}

	public int getMeepleLocation() {
		return meepleLocation;
	}

	public void setMeepleLocation(int meepleLocation) {
		this.meepleLocation = meepleLocation;
	}

	public Meeple getMeeple() {
		return meeple;
	}

	public void setMeeple(Meeple meeple) {
		this.meeple = meeple;
	}

	public String getImageFile() {
		return imageString;
	}

	public void setImageFile(String imageFile) {
		this.imageString = imageFile;
	}

}
