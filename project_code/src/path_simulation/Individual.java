package path_simulation;
/**
 * An Individual of the Population has a current position and an associated path
 * @author Joao, Sara
 */
class Individual {
	Point currPos;
	Path path;
	double timeDeath;
	double comf;
	/**
	 * Creates an Individual with a certain Path
	 * @param pos Position
	 */
	Individual(Point pos){
		currPos=pos;
		path=new Path(pos);
	}
	
	/**
	 * Creates an Individual with a certain Path in a defined Position
	 * @param pos Position
	 * @param p Path
	 */
	Individual(Point pos, Path p) {
		currPos=pos;
		path=p;
	}
	
	/**
	 * Creates an Individual with a Position and a Time of Death
	 * @param pos Current Position
	 * @param _timeDeath Time of Death
	 */
	Individual(Point pos, int _timeDeath){
		currPos = pos;
		path= new Path(pos);
		timeDeath= _timeDeath;
	}
	
	/**
	 * Set a specified comfort
	 * @param _comf Comfort to be set
	 */
	void setComf(double _comf) {
		comf=_comf;
	}
	
	/**
	 * Get the current comfort
	 * @return Current comfort
	 */
	double getComf() {
		return comf;
	}
	
	/**
	 * Set the time of death of an Individual to a certain time
	 * @param _timeDeath Time of Death to be set
	 */
	void setDeath(double _timeDeath) {
		timeDeath=_timeDeath;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + " ; Comf = " + comf + " ; Time of death= " + timeDeath + "\n" + path);
	}
}
