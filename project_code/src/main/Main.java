package main;
import path_simulation.PathSimulation;
/**
 * Main package: responsible for doing the simulation
 * @author Joao, Sara
 */
public class Main{
	/**
	 * 
	 * @param args XML file
	 */
	public static void main(String[] args) {
		//System.out.println("File received in Main: " + args[0]);
		PathSimulation sim = new PathSimulation();
		sim.setupSimulation(args[0]);
		sim.runSimulation();
	}
}