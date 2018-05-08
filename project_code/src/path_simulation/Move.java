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
	
	public void simulateEvent(){
		if(sim.pop.indList.contains(id)) {
			id.currPos=sim.simGrid.getNextPoint(id.currPos, id.currPos.getRandomDir());
			id.path.updatePath(id.currPos);
			updateBestPath(id.path);
			
			double time = sim.setTime(id, sim.moveP);
			if(time< id.timeDeath)
				sim.pec.addEvPEC(new Move(time, id, sim));
		}
	}
	
	public void updateBestPath(Path candidate) {
		if(sim.bestPath==null) //If no path exists, create one
			sim.bestPath = candidate;
		else if (candidate.path.getLast() != sim.finalPoint) {//If the candidate is not the finalPoint
			if(sim.bestPath.path.getLast() == sim.finalPoint) //If the bestPath is already in the finalPoint
				return;
			else if(candidate.path.getLast().getDistance(sim.finalPoint)<candidate.path.getLast().getDistance(sim.finalPoint)) { //If the candidate is closer to the finalPoint than the bestPath
				sim.bestPath = candidate;
			}else if(candidate.path.getLast().getDistance(sim.finalPoint)==sim.bestPath.path.getLast().getDistance(sim.finalPoint) && candidate.cost<sim.bestPath.cost) {
				sim.bestPath = candidate;
			}
		}else{ //If the candidate is the finalPoint 
			if(sim.bestPath.path.getLast() == sim.finalPoint) { //If the finalPoint was already reached, check cost
				if(candidate.cost<sim.bestPath.cost)
					sim.bestPath = candidate;
			}else //If the final point was reached for the first time, update bestPath
				sim.bestPath = candidate; 
		}
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id + " at t = " + time;
	}
}
