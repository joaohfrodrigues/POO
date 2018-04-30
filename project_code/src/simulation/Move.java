package simulation;
import pec.Event;

class Move extends Event{
	Individual id;

	Move(int _time, Individual _id){
		super(_time);
		id=_id;
	}
	
	public void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id;
	}
}
