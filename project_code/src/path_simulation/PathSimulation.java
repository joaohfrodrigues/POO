package path_simulation;
import pec.PEC;
import simulation.Simulation;
/*
 * Path Simulator. Includes the Pending Event Container, current time and simulation time
 * and the population of individuals
 */
public class PathSimulation implements Simulation{
	PEC pec;
	int simulationTime;
	int currentTime;
	Population pop;
	Grid simGrid;
	
	public void defineGrid() {
		
	}
	
	public void defineObstacles() {
		
	}
	
	public void defineEdges() {
		
	}
	
	public void defineEvents() {
		
	}
	
	public void initSimulation() {
		
	}
	
	public void stopSimulation() {
		
	}
	
	//Method that returns a random variable between two numbers, according to some time constants
	int expRandom(){
		return 0;
	}
}
