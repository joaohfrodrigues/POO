package path_simulation;
/*
 * An Individual of the Population has a current position and an associated path
 */
class Individual {
	Point currPos;
	Path path;
	
	Individual(Point pos){
		currPos = pos;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + "\n" + path);
	}
}
