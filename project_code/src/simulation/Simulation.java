package simulation;

/**
 * An Interface for a type of Simulation: has a Pending Event Container (PEC) and implements the abstract methods setupSimulation, 
 * initSimulation and stopSimulation
 * @author Joao
 *
 */
public interface Simulation {
	
	/**
	 * Read the parameters needed to start the simulation: create elements and structures
	 * @param fileName File to be parsed with some parameters of the Simulation
	 */
	void setupSimulation(String fileName);
	
	/**
	 * Initiate the simulation with the parameters already read
	 */
	void runSimulation();
	
	/**
	 * Stop the simulation using an interruption: Not Implemented
	 */
	void stopSimulation();
}
