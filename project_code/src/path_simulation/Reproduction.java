package path_simulation;
import pec.Event;
/*
 * A type of Event that makes an Individual reproduce
 */
class Reproduction extends Event{
	Individual id;
	PathSimulation sim;
	
	Reproduction(double _time, Individual _id, PathSimulation _simulation){
		super(_time);
		id=_id;
		sim=_simulation;
	}
	
	public void simulateEvent(){
		int min_len = (int)(0.9*id.path.getLength());
		int len = min_len + (int)(id.comf*(id.path.getLength()-min_len));		
		Individual child = new Individual(id.path.path.get(len), new Path(id.currPos, id.path.path, id.path.cost));
		sim.initInd(child);
		
		double time = sim.setTime(id, sim.reprP);
		if(time< id.timeDeath)
			sim.pec.addEvPEC(new Reproduction(time, id, sim));
	}
	
	void setChildEvents(Individual child) {
		
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id + " at t = " + time;
	}
}
