package path_simulation;

class Grid {
	Point [][] grid;
	int nrows; //rows
	int ncols; //columns
	
	Grid(int _ncols, int _nrows){
		int x,y;
		nrows=_nrows;
		ncols=_ncols;
		
		if(nrows==0 || ncols==0) {
			System.out.println("Error: invalid parameters; ncols= " + ncols + " nrows= " + nrows);
			System.exit(-1);
		}
		grid = new Point[ncols][nrows];
		int [] edges;
		
		for(x=0;x<ncols;x++) {
			for(y=0;y<nrows;y++) {
				edges= new int[4];
				if(x!=0)
					edges[1]=1;
				if(x!=ncols-1)
					edges[3]=1;
				if(y!=0)
					edges[2]=1;
				if(x!=ncols-1)
					edges[0]=1;
				
				grid[x][y]= new Point(x,y,edges);
			}
		}
	}
	
	void addSPEdges(int xinit, int yinit, int xfinal, int yfinal, int cost) {
		System.out.println("Adding Special Cost Zone between [" + xinit + "," + yinit + "] and [" + xfinal + "," + yfinal + "] with cost= " + cost);
	}
	
	void addObstacle(int xpos, int ypos) {
		System.out.println("Adding Obstacle between [" + xpos + "," + ypos + "]");
	}
	@Override
	public String toString() {
		String ret="";
		for(int x=0; x<ncols; x++)
			for(int y=0; y<nrows; y++)
				ret=ret + grid[x][y].toString() + "\n";
		return ret;
	}
}
