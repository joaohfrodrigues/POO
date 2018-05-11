package path_simulation;
import pec.Event;
/**
 * A type of event that makes an individual die
 */
class Death extends Event{
	Individual id;
	Population pop;

	/**
	 * The Event of death of an Inidivual
	 * @param _time time of the event
	 * @param _id Individual
	 * @param _pop Population at the time of the event
	 */
	Death(double _time, Individual _id, Population _pop){
		super(_time);
		id=_id;
		pop=_pop;
	}
	
	/**
	 * Method to simulate death of an Individual, by removing it from current population
	 */
	public void simulateEvent(){
		if(pop.indList.contains(id)) {
			pop.remIndividual(id);
			id=null;
		}
	}
	
	@Override
	public String toString() {
		return "Event: Death, id = " + id + " at t= " + time;
	}
}