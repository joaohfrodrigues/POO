package main;

import path_simulation.PathSimulation;

/*Main package: responsible for reading the input file
 * Arguments: XML file name
 */
public class Main{
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("File received in Main: " + args[0]);
			PathSimulation sim = new PathSimulation();
			sim.setupSimulation(args[0]);
	}
}