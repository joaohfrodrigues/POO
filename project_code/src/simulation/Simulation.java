package simulation;

/*
 * An Interface for a type of Simulation: has a Pending Event Container (PEC) and implements the abstract methods setupSimulation, initSimulation and stopSimulation
 */
public interface Simulation {
	
	/*
	 * Read the parameters needed to start the simulation: create elements and structures
	 */
	void setupSimulation(String fileName);
	
	/*
	 * Initiate the simulation with the parameters already read
	 */
	void initSimulation();
	
	/*
	 * Stop the simulation using an interruption
	 */
	void stopSimulation();
}
