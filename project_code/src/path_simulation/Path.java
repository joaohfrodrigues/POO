package path_simulation;
import java.util.LinkedList;
import java.util.Iterator;
/*
 * A Path has a Linked List of points that have been visited by an Individual.
 * 
 * The method addPoint adds a Point to the list iff that point hasn't been visited before
 */
class Path {
	int cost;
	LinkedList<Point> path;
	
	Path(){
		path= new LinkedList<Point>();
		cost=0;
	}
	
	Path(Point pos){
		path= new LinkedList<Point>();
		path.add(pos);
		cost=0;
	}
	
	/*
	Path(Point _pos, LinkedList<Point> _path, int _cost){
		path=_path;
		cost=_cost;
	}
	*/
	
	/*
	 * Method that updates the path of an Individual and removes the path when it returns to a Point already visited
	 */
	void updatePath(Point p){
		int idx=path.indexOf(p);
		if(idx==-1) {
			cost+=getMoveCost(path.getLast(),p);
			path.add(p);
			//System.out.println("Added to Path Point" + p);
		}else {
			while(true) {
				try {
					path.remove(idx+1);
				}catch(Exception e) {
					//System.out.println("Same point: path removed");
					break;
				}
			}
			cost=calcPathCost();
		}
	}
	
	int getPathCost(){
		return cost;
	}
	
	void setPath(LinkedList<Point> _path) {
		path=_path;
	}
	
	void setCost(int _cost) {
		cost=_cost;
	}
	
	/*
	 * Method the returns the total path cost
	 */
	int calcPathCost() {
		if (path.size()<2) {
			//System.out.println("Path has only 1 point");
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
	
	/*
	 * Method that returns the current length of the path
	 */
	int getLength() {
		return path.size();
	}
	
	/*
	 * Method that returns the cost of the next move
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
		String ret="Path with cost= " + cost + " and length= " + getLength() + "\n";
		Iterator<Point> it= this.path.iterator();
		while(it.hasNext()) {
			ret= ret + it.next().toString() + "\n";
		}
		return ret;
	}
}
