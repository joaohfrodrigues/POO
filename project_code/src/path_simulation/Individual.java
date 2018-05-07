package path_simulation;
/*
 * An Individual of the Population has a current position and an associated path
 */
class Individual {
	Point currPos;
	Path path;
	int timeDeath;
	
	Individual(Point pos){
		currPos=pos;
		path=new Path();
	}
	
	Individual(Point pos, int _timeDeath){
		currPos = pos;
		path= new Path();
		timeDeath= _timeDeath;
	}
	
	/*
	 * Method that sets the time of death of an Individual to a certain time
	 */
	void setDeath(int _timeDeath) {
		timeDeath=_timeDeath;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + " ; Time of death= " + timeDeath + "\n" + path);
	}
}
