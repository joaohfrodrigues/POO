package path_simulation;
import java.util.LinkedList;
/*
 * A Path has a Linked List of points that have been visited by an Individual.
 * 
 * The method addPoint adds a Point to the list iif that point hasn't been visited before
 */
class Path {
	int cost;
	LinkedList<Point> path;
	
	Path(){
		path= new LinkedList<Point>();
	}
	
	void updatePath(Point p){
		int idx=path.indexOf(p);
		if(idx==-1) {
			path.add(p);
			System.out.println("Added Point" + p);
		}else {
			try {
				path.remove(idx);
			}catch(Exception e) {
				System.out.println("Same point: path removed");
			}
		}
	}
}
