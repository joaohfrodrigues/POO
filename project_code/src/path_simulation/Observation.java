package path_simulation;
import pec.Event;
/*
 * A type of event that prints on the terminal an observation of the Simulation
 */
class Observation extends Event{
	PathSimulation simulation;
	
	Observation(double _time, PathSimulation _simulation){
		super(_time);
		simulation = _simulation;
	}
	
	public void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Observation at t = " + time;
	}
}