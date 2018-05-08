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
	 
	/*
	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;		
		if(!Event.class.isAssignableFrom(obj.getClass())) return false;
		
		final Event other = (Event) obj;
		
		if (this.time == other.time && this.prob == other.prob)
			return true;
		
		return false;
	}
	*/
	public abstract void simulateEvent();
	/*
	public int compareTime(Event e1) {
		if(this.time > e1.time) return 1;
		else if(this.time == e1.time) return 0;
		else return -1;
	}
	*/
	
}
