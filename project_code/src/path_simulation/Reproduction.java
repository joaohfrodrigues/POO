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
		//add comfort, denoted here as x
		//min_len += (int)(x*(id.path.getLength()-min_len));
		Path inherited = new Path();
		//inherited.path = id.path.subList(0, min_len);
		inherited.cost = inherited.getPathCost();
		
		Individual child = new Individual(id.path.path.get(min_len), inherited);
		pop.addIndividual(child);
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id;
	}
}
