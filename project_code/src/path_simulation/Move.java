package path_simulation;
import pec.Event;
/*
 * A type of event that makes an Individual move
 */
class Move extends Event{
	Individual id;

	Move(int _time, Individual _id){
		super(_time);
		id=_id;
	}
	
	public void simulateEvent(){
		Path path = this.id.path;
		Point here = this.id.currPos;
		//int mean = (1 - Math.log(id.comfort(data, cmax)))*k
		
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id;
	}
}
