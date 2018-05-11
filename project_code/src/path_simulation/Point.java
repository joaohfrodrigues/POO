package path_simulation;
import java.util.Random;

/**
 * Class Point: has the row, column and the edges vector [north west south east]
 * @author Joao, Sara
 *
 */
class Point {
	int column;
	int row;
	int [] edges = new int[4];
	
	/**
	 * Creates a Point with a certain position deifined by x and y
	 * @param _x Column
	 * @param _y Row
	 */
	Point(int _x,int _y) {
		column=_x;
		row=_y;
		for(int i=0;i<4;i++) {
			edges[i]=1;
		}
	}
	
	/**
	 * Creates a Point according to x, y and the edges vector
	 * @param _x Column
	 * @param _y Row
	 * @param _edges Vector of Edges
	 */
	Point(int _x, int _y, int[] _edges){
		column=_x;
		row=_y;
		edges=_edges;
	}
	
	/**
	 * Generates a random direction out of the possible ones for an Individual to move to
	 * @return Direction of the next Move
	 * @throws NoPossibleMoves In the case there are no Moves available
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
			count=Math.abs(r.nextInt()%count);//count is now a value between 0 and count 
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
		return ret;
	}

	/**
	 * Calculate distance from current point to the one given
	 * @param p Given Point
	 * @return Distance between the two Points
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