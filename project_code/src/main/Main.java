package main;
import path_simulation.PathSimulation;
/*
 * Main package: responsible for doing the simulation
 * Arguments: XML file name
 */
public class Main{
	public static void main(String[] args) {
		//System.out.println("File received in Main: " + args[0]);
		PathSimulation sim = new PathSimulation();
		sim.setupSimulation(args[0]);
		sim.runSimulation();
	}
}