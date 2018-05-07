package path_simulation;
import pec.Event;
/*
 * A type of event that makes an individual die
 */
class Death extends Event{
	Individual id;
	Population pop;
	
	Death(int _time, Individual _id, Population _pop){
		super(_time);
		id=_id;
		pop=_pop;
	}
	
	public void simulateEvent(){
		pop.indList.remove(id);
		id=null;
	}
	
	@Override
	public String toString() {
		return "Event: Death, id = " + id;
	}
}