package path_simulation;
import java.util.LinkedList;
import java.util.Iterator;
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
		int stop=0;
		int idx=path.indexOf(p);
		if(idx==-1) {
			path.add(p);
			System.out.println("Added to Path Point" + p);
		}else {
			while(stop==0) {
				try {
					path.remove(idx+1);
				}catch(Exception e) {
					stop=1;
					System.out.println("Same point: path removed");
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String ret="";
		Iterator<Point> it= this.path.iterator();
		while(it.hasNext()) {
			ret= ret + it.next().toString() + "\n";
		}
		return ret;
	}
}
