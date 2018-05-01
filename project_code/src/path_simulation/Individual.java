package path_simulation;

class Individual {
	Point curr_position;
	Path path;
	
	Individual(Point pos){
		curr_position = pos;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + curr_position);
	}
}
