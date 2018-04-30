package simulation;
import pec.Event;

class Reproduction extends Event{
	int id;
	
	Reproduction(int _time, int _id){
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
