package path_simulation;
/*
 * An Individual of the Population has a current position and an associated path
 */
class Individual {
	Point currPos;
	Path path;
	int timeDeath;
	
	Individual(Point pos, int _timeDeath){
		currPos = pos;
		path= new Path();
		timeDeath= _timeDeath;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + " ; Time of death= " + timeDeath + "\n" + path);
	}
}
