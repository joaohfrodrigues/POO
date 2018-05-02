package simulation;
import pec.PEC;
/*
 * An Interface for a type of Simulation: has a Pending Event Container (PEC) and implements the abstract methods setupSimulation, initSimulation and stopSimulation
 */
public interface Simulation {
	PEC pec= new PEC();
	void setupSimulation(String fileName);
	void initSimulation();
	void stopSimulation();
}
