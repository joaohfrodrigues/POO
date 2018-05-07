package path_simulation;
import pec.Event;
/*
 * A type of event that makes an Individual move
 */
class Move extends Event{
	Individual id;
	Grid grid;

	Move(double _time, Individual _id, Grid _grid){
		super(_time);
		id=_id;
		grid=_grid;
	}
	
	public void simulateEvent(){
		id.currPos=grid.getNextPoint(id.currPos, id.currPos.getRandomDir());
		id.path.updatePath(id.currPos);
	}
	
	@Override
	public String toString() {
		return "Event: Move , id= " + id;
	}
}
