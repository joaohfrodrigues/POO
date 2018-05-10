package path_simulation;
import pec.Event;
/*
 * A type of event that makes an Individual move
 */
class Move extends Event{
	Individual id;
	PathSimulation sim;

	Move(double _time, Individual _id, PathSimulation _sim){
		super(_time);
		id=_id;
		sim=_sim;
	}
	
	/*
	 * Method to simulate the movement of an Individual on the grid
	 */
	public void simulateEvent(){
		if(sim.pop.indList.contains(id)) {
			// search new possible direction to take from current point
			int dir;
			try {
				dir=id.currPos.getRandomDir();
			}catch(NoPossibleMoves np){
				System.out.println(np.getMessage());
				System.exit(-1);
				return;
			}
			
			id.currPos=sim.simGrid.getNextPoint(id.currPos, dir);
			//System.out.println("New position= " + id.currPos);
			id.path.updatePath(id.currPos);
			updateBestPath(id);
			
			double time = sim.currTime + sim.setTime(id, sim.moveP);
			//System.out.println("New event at time = " + time);
			if(time< id.timeDeath)
				sim.pec.addEvPEC(new Move(time, id, sim));
		}
	}
	
	/*
	 * Update current best path performed, by searching through all the population, and save it
	 */
	void updateBestPath(Individual candidate) {
		if(sim.bestPath==null) { //If no path exists, create one
			sim.bestPath = copyPath(candidate.path);
			sim.bestComfort = candidate.comf;
		}else if (candidate.path.path.getLast() != sim.finalPoint) {//If the candidate is not the finalPoint
			if(sim.bestPath.path.getLast() == sim.finalPoint) //If the bestPath is already in the finalPoint
				return;
			else if(candidate.path.path.getLast().getDistance(sim.finalPoint)<candidate.path.path.getLast().getDistance(sim.finalPoint)) { //If the candidate is closer to the finalPoint than the bestPath
				sim.bestPath = copyPath(candidate.path);
				sim.bestComfort = candidate.comf;
			}else if(candidate.path.path.getLast().getDistance(sim.finalPoint)==sim.bestPath.path.getLast().getDistance(sim.finalPoint) && candidate.path.cost<sim.bestPath.cost) {
				sim.bestPath = copyPath(candidate.path);
				sim.bestComfort = candidate.comf;
			}
		}else{ //If the candidate is the finalPoint 
			if(sim.bestPath.path.getLast() == sim.finalPoint) { //If the finalPoint was already reached, check cost
				if(candidate.path.cost<sim.bestPath.cost) {
					sim.bestPath = copyPath(candidate.path);
					sim.bestComfort = candidate.comf;
				}
			}else { //If the final point was reached for the first time, update bestPath
				sim.bestPath = copyPath(candidate.path);
				sim.bestComfort = candidate.comf;
			}
		}
	}
	
	/*
	 * Copy a given path
	 */
	Path copyPath(Path newBest) {
		Path ret= new Path();
		ret.cost=newBest.cost;
		
		for(Point p:newBest.path) {
			ret.path.add(p);
		}
			
		return ret;
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id + " at t = " + time;
	}
}
