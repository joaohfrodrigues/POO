package path_simulation;
import pec.Event;

class Observation extends Event{

	Observation(int _time){
		super(_time);
	}
	
	public void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Observation";
	}
}