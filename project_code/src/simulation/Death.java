package simulation;
import pec.Event;

class Death extends Event{
	int id;
	
	Death(int _time, int _id){
		super(_time);
		id=_id;
	}
	
	public void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Death, id = " + id;
	}
}