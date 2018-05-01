package path_simulation;

class Grid {
	Point [][] simGrid;
	int nrows; //rows
	int ncols; //columns
	
	Grid(int _ncols, int _nrows){
		int x,y;
		nrows=_nrows;
		ncols=_ncols;
		simGrid = new Point[ncols][nrows];
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
				
				simGrid[x][y]= new Point(x,y,edges);
			}
		}
	}
	
	@Override
	public String toString() {
		String ret="";
		for(int x=0; x<ncols; x++)
			for(int y=0; y<nrows; y++)
				ret=ret + simGrid[x][y].toString() + "\n";
		return ret;
	}
}
