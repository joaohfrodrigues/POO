package path_simulation;

class Individual {
	Point curr_position;
	Path path;
	
	Individual(int x, int y){
		curr_position = new Point(x,y);
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + curr_position);
	}
}
