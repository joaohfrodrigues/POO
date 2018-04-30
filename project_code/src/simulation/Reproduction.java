package simulation;
import pec.Event;

class Reproduction extends Event{
	Individual id;
	
	Reproduction(int _time, Individual _id){
		super(_time);
		id=_id;
	}
	
	public void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id;
	}
}
