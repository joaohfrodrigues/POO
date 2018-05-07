package path_simulation;
import java.util.Arrays;
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
	
	int getDistance(Point p) {
		return Math.abs(this.column-p.column) + Math.abs(this.row-p.row);
	}
	
	int getRandomDir() {
		int ret=-1;
		int count=0;
		Random r = new Random();
		
		for(int i=0; i<4;i++)
			if(edges[i]!=0)
				count++;
		/*count is now a value between 0 and count*/ 
		count=r.nextInt()%count;
		
		while(ret==-1) {
			if(edges[count]!=0)
				ret=edges[count];
			count++;
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		int x=column+1;
		int y=row+1;
		return("x= " + x + " y= " + y + " ; Edges = " + Arrays.toString(edges));
	}
}