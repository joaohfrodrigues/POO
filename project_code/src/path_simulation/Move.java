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
		//Point next = id.currPos.getNextPoint();
		
		//next.checkEdges();
		//id.path.updatePath(next);
		//id.currPos = next;
			
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id;
	}
}
