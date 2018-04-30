package path_simulation;

class Point {
	int x;
	int y;
	
	Point(int _x, int _y){
		x=_x;
		y=_y;
	}
	
	@Override
	public String toString() {
		return("x= " + x + " y= " + y);
	}
}
