package simulation;

class Grid {
	boolean [][] sim_grid;
	
	Grid(int height, int length, boolean [][] obst_pos){
		sim_grid= new boolean [height][length];
		
		for(int x=0;x<height;x++) {
			for(int y=0;y<length;y++) {
				if (obst_pos[x][y]==true)
					sim_grid[x][y]=true;
				else
					sim_grid[x][y]=false;
			}
		}
	}
	
	boolean isObstacle(int x, int y) {
		if (sim_grid[x][y]==true)
			return true;		
		return false;
	}
}
