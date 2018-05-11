package pec;
import java.util.*;

/**
 * Implementation of the pending event container. A class named Event must be defined in order to use the PEC
 * @author Joao,Sara
 *
 */
public class PEC {
	TreeSet <Event> ev_set;
	
	/**
	 * Creates a new PEC
	 */
	public PEC(){
		ev_set = new TreeSet<Event>(new CompByTime());
	}
	
	/**
	 * Add a new Event to current PEC
	 * @param ev Event to be added
	 */
	public void addEvPEC(Event ev) {
		ev_set.add(ev);
	}
	
	/**
	 * Fetch the first Event located at the beginning of the PEC
	 * @return Event located in the beginning of the PEC
	 */
	public Event nextEvPEC(){
		return ev_set.pollFirst();
	}
	
	@Override
	public String toString() {
	    String ret="";
		for(Event e:ev_set)
	        ret=ret + e.toString() + "\n";
		return ret;
	}

}

/**
 * Class extending Comparator with compare method to sort the Events in the PEC chronologically
 * @author Joao,Sara
 *
 */
class CompByTime implements Comparator <Event>{
	/**
	 * Order Events of the PEC chronologically
	 */
	public int compare(Event e1, Event e2) {
		if(e1.time > e2.time) return 1;
		else if(e1.time == e2.time) return 0;
		else return -1;
	}
}