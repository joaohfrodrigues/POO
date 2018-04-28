package simulation;

class Reproduction extends Event{
	Reproduction(int _time, int _id){
		super(_time,_id);
	}
	
	void simulateEvent(){
		
	}
	
	@Override
	public String toString() {
		return "Event: Reproduction , Time: " + time;
	}
}
