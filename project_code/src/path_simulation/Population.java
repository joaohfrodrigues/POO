package path_simulation;
import java.util.LinkedList;
/*
 * A Population has a the current size, the max size and a method that applies an Epidemics to the current Population
 */
class Population {
	int size;
	int maxSize;
	LinkedList<Individual> indList;
	
	Population(int _size, int _maxSize){
		size=_size;
		maxSize=_maxSize;
		indList = new LinkedList<Individual>();
	}
	
	void addIndividual(Individual ind) {
		indList.add(ind);
	}
	
	void remIndividual(Individual ind) {
		indList.remove(ind);
	}
	
	void epidemics() {
		
	}
}
