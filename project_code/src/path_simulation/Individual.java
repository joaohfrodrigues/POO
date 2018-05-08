package path_simulation;
/*
 * An Individual of the Population has a current position and an associated path
 */
class Individual {
	Point currPos;
	Path path;
	double timeDeath;
	double comf;
	
	Individual(Point pos){
		currPos=pos;
		path=new Path(pos);
	}
	
	Individual(Point pos, Path p) {
		currPos=pos;
		path=p;
	}
	
	Individual(Point pos, int _timeDeath){
		currPos = pos;
		path= new Path(pos);
		timeDeath= _timeDeath;
	}
	
	void setComf(double _comf) {
		comf=_comf;
	}
	
	double getComf() {
		return comf;
	}
	
	/*
	 * Method that sets the time of death of an Individual to a certain time
	 */
	void setDeath(double _timeDeath) {
		timeDeath=_timeDeath;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + " ; Time of death= " + timeDeath + "\n" + path);
	}
}
