package pec;
import java.util.*;
/*
 * Implementation of the pending event container. A class named Event must be defined in order to use the PEC
 */
public class PEC {
	TreeSet <Event> ev_set;
	
	public PEC(){
		ev_set = new TreeSet<Event>(new CompByTime());
	}
	
	public void addEvPEC(Event ev) {
		ev_set.add(ev);
	}
	
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

class CompByTime implements Comparator <Event>{
	public int compare(Event e1, Event e2) {
		if(e1.time > e2.time) return 1;
		else if(e1.time == e2.time) return 0;
		else return -1;
	}
}