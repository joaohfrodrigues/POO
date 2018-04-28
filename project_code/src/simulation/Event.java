package simulation;
/*
 * Can be Death, Reproduction or Move, in the project
 */
public abstract class Event {
	int time;
	int prob;
	
	Event(int _time, int _prob){
		time=_time;
		prob=_prob;
	}
	
	abstract void simulateEvent();
}
