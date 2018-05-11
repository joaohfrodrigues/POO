package path_simulation;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * A Path has a Linked List of points that have been visited by an Individual, and its cost.
 * @author Joao
 *
 */
class Path {
	int cost;
	LinkedList<Point> path;
	
	/**
	 * Creates a new empty path
	 */
	Path(){
		path= new LinkedList<Point>();
		cost=0;
	}
	
	/**
	 * Creates a new path, beginning in a defined Position
	 * @param pos Initial Position of the new Path
	 */
	Path(Point pos){
		path= new LinkedList<Point>();
		path.add(pos);
		cost=0;
	}
	
	/**
	 * Update the path of an Individual and remove the path when it returns to a Point already visited
	 * @param p Point to be added to the Path
	 */
	void updatePath(Point p){
		int idx=path.indexOf(p);
		if(idx==-1) {
			cost+=getMoveCost(path.getLast(),p);
			path.add(p);
		}else {
			while(true) {
				try {
					path.remove(idx+1);
				}catch(Exception e) {
					break;
				}
			}
			cost=calcPathCost();
		}
	}
	
	/**
	 * Returns the variable cost of the Path
	 * @return Cost of the Path
	 */
	int getPathCost(){
		return cost;
	}
	
	/**
	 * Sets a defined path
	 * @param _path Path to be stored
	 */
	void setPath(LinkedList<Point> _path) {
		path=_path;
	}
	
	/**
	 * Set a new cost for the Path
	 * @param _cost New cost of path
	 */
	void setCost(int _cost) {
		cost=_cost;
	}
	
	/**
	 * Method the returns the total Path cost
	 * @return Total Path cost
	 */
	int calcPathCost() {
		if (path.size()<2) {
			return 0;
		}
		int price=0;
		Iterator<Point> it= this.path.iterator();
		Point aux=it.next();
		Point auxNext=it.next();
		price+=getMoveCost(aux,auxNext);
		while(it.hasNext()) {
			aux=auxNext;
			auxNext=it.next();
			price+=getMoveCost(aux,auxNext);
		}
		return price;
	}
	
	/**
	 * Method that returns the current length of the path
	 * @return Current length of the Path
	 */
	int getLength() {
		return path.size();
	}
	
	/**
	 * Method that returns the cost of the next move
	 * @param p1 Current Point
	 * @param p2 Next Point
	 * @return Cost of moving form the current Point to the next Point
	 */
	int getMoveCost(Point p1, Point p2) {
		int ret=0;
		if(p1.column==p2.column-1) {
			ret=p1.edges[3];
		}else if(p1.column == p2.column+1) {
			ret=p1.edges[1];
		}else if(p1.row==p2.row-1) {
			ret=p1.edges[0];
		}else if(p1.row==p2.row+1) {
			ret=p1.edges[2];
		}
		return ret;
	}
	
	
	@Override
	public String toString() {
		String ret="{";
		Iterator<Point> it= this.path.iterator();
		while(it.hasNext()) {
			ret+= it.next().toString();
		}
		ret+="}";
		return ret;
	}
}
