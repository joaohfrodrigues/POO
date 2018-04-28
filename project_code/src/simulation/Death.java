package simulation;

class Death extends Event{
	Death(int _time, int _id){
		super(_time, _id);
	}
	
	void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Death , Time: " + time;
	}
}