package simulation;
/*
 * Can be Death, Reproduction or Move, in the project
 */
public abstract class Event {
	int time;
	int id;
	
	Event(int _time, int _id){
		time=_time;
		id=_id;
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
	abstract void simulateEvent();
	
	public int compareTime(Event e1) {
		if(this.time > e1.time) return 1;
		else if(this.time == e1.time) return 0;
		else return -1;
	}
}
