package pec;
/*
 * A Generic Event, that has an associated time and implements the abstract method simulateEvent
 */
public abstract class Event {
	protected double time;
	
	public Event(double _time){
		time=_time;
	}
	
	public double getTime() {
		return time;
	}
	 
	public abstract void simulateEvent();

	
}
