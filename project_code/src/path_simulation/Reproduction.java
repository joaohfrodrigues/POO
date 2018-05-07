package path_simulation;
import pec.Event;
/*
 * A type of Event that makes an Individual reproduce
 */
class Reproduction extends Event{
	Individual id;
	Population pop;
	
	Reproduction(double _time, Individual _id, Population _pop){
		super(_time);
		id=_id;
		pop=_pop;
	}
	
	public void simulateEvent(){
		int min_len = (int)(0.9*id.path.getLength());
		int len = min_len + (int)(id.comf*(id.path.getLength()-min_len));
		Path inherited = new Path(id.currPos);
		inherited.setPath(id.path.path);
		//.subList(0, len)
		inherited.setCost(id.path.getPathCost());
		
		Individual child = new Individual(id.path.path.get(len), inherited);
		pop.addIndividual(child);
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id + " at t = " + time;
	}
}
