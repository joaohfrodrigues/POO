package path_simulation;
import java.util.Random;
/*
 * Class Point: has the row, column and the edges vector [up left down right]
 * 
 */
class Point {
	int column;
	int row;
	int [] edges = new int[4];
	
	Point(int _x,int _y) {
		column=_x;
		row=_y;
		for(int i=0;i<4;i++) {
			edges[i]=1;
		}
	}
	
	Point(int _x, int _y, int[] _edges){
		column=_x;
		row=_y;
		edges=_edges;
	}
	
	/*
	 * Method to return a random direction out of the possible ones for an Individual to move to
	 */
	int getRandomDir() throws NoPossibleMoves{
		int ret=-1;
		int count=0;
		Random r = new Random();
		
		// count available directions to take from current point
		for(int i=0; i<4;i++)
			if(edges[i]!=0)
				count++;
		
		if(count != 0)
			count=Math.abs(r.nextInt()%count);/*count is now a value between 0 and count*/ 
		else
			throw new NoPossibleMoves("No Possible Moves");
		int aux=0;
		
		for(int i=0; i<4;i++) {
			if(edges[i]!=0) {
				if(aux!=count)
					aux++;
				else {
					ret=i;
					break;
				}
			}
		}
		
		//System.out.println("\n" + ret + "\n");
		return ret;
	}

	/*
	 * Calculate distance from current point to the one given
	 */
	int getDistance(Point p) {
		return Math.abs(this.column-p.column) + Math.abs(this.row-p.row);
	}
	
	@Override
	public String toString() {
		int x=column+1;
		int y=row+1;
		return("(" + x + "," + y + ")");
	}
}