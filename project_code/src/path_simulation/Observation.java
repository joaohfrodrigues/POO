package path_simulation;
import pec.Event;
/*
 * A type of event that prints on the terminal an observation of the Simulation
 */
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