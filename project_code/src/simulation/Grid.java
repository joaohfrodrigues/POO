package simulation;

class Grid {
	boolean [][] simGrid;
	
	Grid(int height, int length, boolean [][] obstPos){
		simGrid= new boolean [height][length];
		
		for(int x=0;x<height;x++) {
			for(int y=0;y<length;y++) {
				if (obstPos[x][y]==true)
					simGrid[x][y]=true;
				else
					simGrid[x][y]=false;
			}
		}
	}
	
	boolean isObstacle(int x, int y) {
		if (simGrid[x][y]==true)
			return true;		
		return false;
	}
}
