package simulation;

class Death extends Event{
	Death(int _time, int _prob){
		super(_time, _prob);
	}
	
	void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Death ; Time: " + time;
	}
}
