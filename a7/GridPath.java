package a7;

import java.util.Arrays;

public class GridPath {

	public static final boolean DOWN = false;
	public static final boolean RIGHT = true;

	private boolean[] path;

	public GridPath(int[][] map) {
		path = new boolean[100];
		int rightCost;
		int downCost;
		for (int i=map.length-1; i>=0; i--) {
            for (int j=map[0].length-1; j>=0; j--) {
                    if (i == map.length-1 && j == map[0].length - 1) continue;
                    downCost = Integer.MAX_VALUE;
                    rightCost = Integer.MAX_VALUE;
                    if (j+1 < map[0].length) rightCost = map[i][j+1];
                    if (i+1 < map.length) downCost = map[i+1][j];
                    if(rightCost < downCost) map[i][j]+= rightCost;
                    else map[i][j] += downCost;
            }
    }

		int i = 0;
		int j = 0;
		int count = 0;
		
		while (i < map.length-1 || j < map.length-1) {
            downCost = Integer.MAX_VALUE;
            rightCost = Integer.MAX_VALUE;
            if (j+1 < map[0].length) rightCost = map[i][j+1];
            if (i+1 < map.length) downCost = map[i+1][j];
            if (rightCost < downCost) {
            	path[count] = RIGHT;
                    j++;
            } else {
				path[count] = DOWN;
                    i++;
            }
            count++;
    }
	}

	public boolean path(int i) {
		return path[i];
	}
	
	public void printPath(){
		System.out.println(Arrays.toString(path));		
	}
}
