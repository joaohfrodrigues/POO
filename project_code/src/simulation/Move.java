package simulation;

class Move extends Event{
	Move(int _time, int _prob){
		super(_time,_prob);
	}
	
	void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Move ; Time: " + time;
	}
}
