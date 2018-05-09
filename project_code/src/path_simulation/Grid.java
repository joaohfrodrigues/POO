package path_simulation;
/*
 * The Grid has a matrix of Points, based on the number of rows and columns of the PathSimulation
 */
class Grid {
	Point [][] grid;
	int ncols; //columns
	int nrows; //rows
	
	Grid(int _ncols, int _nrows){
		int x,y;
		ncols=_ncols;
		nrows=_nrows;
		
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
				if(y!=nrows-1)
					edges[0]=1;
				
				grid[x][y]= new Point(x,y,edges);
			}
		}
	}
	
	/*
	 * Get the next point, with direction 
	 */
	Point getNextPoint(Point p, int dir){
		Point ret = grid[p.column][p.row];
		//System.out.println(dir);
		switch(dir) {
			case 0:
				ret=grid[p.column][p.row+1];
				break;
			case 1:
				ret=grid[p.column-1][p.row];
				break;
			case 2:
				ret=grid[p.column][p.row-1];
				break;
			case 3:
				ret=grid[p.column+1][p.row];
				break;
		}
		return ret;
	}
	
	void addSPEdges(int x1, int y1, int x2, int y2, int cost) {
		//System.out.println("Adding Special Cost Zone between [" + x1 + "+1 ," + y1 + "+1] and [" + x2 + "+1 ," + y2 + "+1] with cost= " + cost);
		int xinit, yinit, xfinal, yfinal;
		int x,y;
		//DEFINE POS_INIT AND POS_FINAL BASED ON THE ENTRY POINTS
		if(x1<=x2) {
			xinit=x1;
			yinit=y1;
			xfinal=x2;
			yfinal=y2;
		}else {
			xinit=x2;
			yinit=y2;
			xfinal=x1;
			yfinal=y1;
		}
		
		for(x=xinit; x<=xfinal;x++) {
			if(x!=xinit) {
				applyCost(x,yinit,1,cost);
				applyCost(x,yfinal,1,cost);	
			}
			if(x!=xfinal) {
				applyCost(x,yinit,3,cost);
				applyCost(x,yfinal,3,cost);
			}
		}
		for(y=yinit; y<=yfinal;y++) {
			if(y!=yinit) {
				applyCost(xinit,y,2,cost);
				applyCost(xfinal,y,2,cost);
			}
			if(y!=yfinal) {
				applyCost(xinit,y,0,cost);
				applyCost(xfinal,y,0,cost);
			}
		}
			
	}
	
	void applyCost(int x, int y, int direction, int cost) {
		if(grid[x][y].edges[direction]<cost && grid[x][y].edges[direction]!=0) {
			grid[x][y].edges[direction]=cost;
		}
	}
	
	void addObstacle(int xpos, int ypos) {
		//System.out.println("Adding Obstacle in [" + xpos + "+1 ," + ypos + "+1]");
		for(int i=0; i<4;i++) {
			grid[xpos][ypos].edges[i]=0;
		}
		if(xpos+1<ncols) {
			grid[xpos+1][ypos].edges[1]=0;
		}
		if(xpos-1>=0) {
			grid[xpos-1][ypos].edges[3]=0;
		}
		if(ypos+1<nrows) {
			grid[xpos][ypos+1].edges[2]=0;
		}
		if(ypos-1>=0) {
			grid[xpos][ypos-1].edges[0]=0;
		}
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
