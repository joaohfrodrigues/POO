package simulation;
import pec.Event;

class Death extends Event{
	Individual id;
	
	Death(int _time, Individual _id){
		super(_time);
		id=_id;
	}
	
	public void simulateEvent(){
		id=null;
	}
	
	@Override
	public String toString() {
		return "Event: Death, id = " + id;
	}
}