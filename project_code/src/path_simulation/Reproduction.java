package path_simulation;
import pec.Event;
/*
 * A type of Event that makes an Individual reproduce
 */
class Reproduction extends Event{
	Individual id;
	Population pop;
	
	Reproduction(int _time, Individual _id, Population _pop){
		super(_time);
		id=_id;
		pop=_pop;
	}
	
	public void simulateEvent(){
		//int mean = (1 - Math.log(id.comfort(data, cmax)))*k
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , id= " + id;
	}
}
