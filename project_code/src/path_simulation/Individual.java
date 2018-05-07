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
	
	int comfort(PathSimulation data, int cmax) {
		int cost = path.cost;
		int len_p = path.getLength();
		
		int dist = data.finalPoint.column - currPos.column;
		dist += data.finalPoint.row - currPos.row;
		
		int comf = (1 - (cost-len_p+2)/((cmax-1)*len_p+3))^data.comfortSens;
		comf *= (1 - dist/(data.simGrid.ncols + data.simGrid.nrows +1))^data.comfortSens;
		
		return comf;
	}
	
	@Override
	public String toString() {
		return("Individual in position: " + currPos + " ; Time of death= " + timeDeath + "\n" + path);
	}
}
