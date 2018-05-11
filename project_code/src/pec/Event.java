package pec;
/**
 * A Generic Event, that has an associated time and implements the abstract method simulateEvent
 * @author Joao,Sara
 *
 */
public abstract class Event {
	protected double time;
	/**
	 * Creates an Event
	 * @param _time Time of the Event
	 */
	public Event(double _time){
		time=_time;
	}
	
	/**
	 * Returns the time of the event
	 * @return time
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * Method that does all the computation related to the simulation of a certain Event
	 */
	public abstract void simulateEvent();

	
}
