package simulation;
import pec.PEC;

public interface Simulation {
	PEC pec= new PEC();
	void setupSimulation(String fileName);
	void initSimulation();
	void stopSimulation();
}
