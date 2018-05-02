package path_simulation;
import java.util.Iterator;
import java.util.LinkedList;
/*
 * A Population has a the current size, the max size and a method that applies an Epidemics to the current Population
 */
class Population {
	int size;
	int maxSize;
	LinkedList<Individual> indList;
	
	Population(int _maxSize){
		maxSize=_maxSize;
		if(maxSize>=0)
			indList = new LinkedList<Individual>();
		else {
			System.out.println("Max size of population must be greater than 0");
		}
	}
	
	void addIndividual(Individual ind) {
		indList.add(ind);
		size++;
		
		if(size>maxSize)
			epidemics();
	}
	
	void remIndividual(Individual ind) {
		indList.remove(ind);
		size--;
	}
	
	void epidemics() {
		
	}
	
	@Override
	public String toString() {
		String ret="";
		ret = ret + "Population: size= " + size + "\n";
		Iterator<Individual> it= this.indList.iterator();
		while(it.hasNext()) {
			ret= ret + it.next().toString() + "\n";
		}
		return ret;
		
	}
}
