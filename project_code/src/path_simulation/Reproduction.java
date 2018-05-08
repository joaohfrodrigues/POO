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
		if (sim.pop.indList.contains(id)) {
			int min_len = (int)(0.9*id.path.getLength());
			int len = min_len + (int)(id.comf*(id.path.getLength()-min_len));		
			Path childPath = new Path(sim.initPoint);
			
			for(int i=0; i<len; i++) {
				childPath.path.add(id.path.path.get(i));
			}
			
			Individual child = new Individual(id.currPos,childPath);
			sim.initInd(child);
			
			double time = sim.setTime(id, sim.reprP);
			if(time< id.timeDeath)
				sim.pec.addEvPEC(new Reproduction(time, id, sim));
		}
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id + " at t = " + time;
	}
}
