package simulation;

class Move extends Event{
	Move(int _time, int _id){
		super(_time,_id);
	}
	
	void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Move , Time: " + time;
	}
}
