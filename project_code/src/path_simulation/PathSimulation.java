package path_simulation;
import java.io.File;
import java.util.Random;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import simulation.Simulation;
/*
 * Path Simulator. Includes the Pending Event Container, current time and simulation time
 * and the population of individuals
 */
public class PathSimulation implements Simulation{
	int currTime;
	int finalInst;
	Grid simGrid;
	int comfortSens;
	Point initPoint;
	Point finalPoint;
	int nObsts;
	int nZones;
	int deathP;
	int reprP;
	int moveP;
	Path bestPath;
	Population pop;
	int initPop=0;
	int maxPop=0;
	int cmax=0; //maximum cost of an edge in the grid
	
	public void setupSimulation(String fileName) {
		this.parseFile(fileName); //Read File
		currTime=0;
		
		System.out.println("currTime = " + currTime);
		System.out.println("finalInst = " + finalInst);
		System.out.println("initPop= " + initPop);
		System.out.println("maxPop = " + maxPop);
		System.out.println("comfortSens = " + comfortSens);
		
		System.out.println("Grid: \n" + simGrid);
		
		System.out.println("Initial Point: " + initPoint);
		System.out.println("Final Point: " + finalPoint);

		System.out.println("Number of Special Cost Zones: " + nZones);
		System.out.println("Number of Obstacles: " + nObsts);
		
		System.out.println("Death Parameter: " + deathP);
		System.out.println("Reproduction Parameter: " + reprP);
		System.out.println("Move Parameter: " + moveP);
		
		pop=new Population(maxPop);
		int timeDeath=0;
		for(int i=0;i<initPop;i++) {
			timeDeath=initEvents();
			pop.addIndividual(new Individual(initPoint,timeDeath));
		}
			
		
		System.out.println(pop);
		int n1=expRandom(1);
		int n2=expRandom(2);
		
		System.out.println(n1 + "" + n2);
	}
	
	public void initSimulation() {
		
	}
	
	public void stopSimulation() {
		
	}
	
	int initEvents() {
		
		return 0;
	}
	
	/*
	 * Method that returns a random variable between two numbers, according to some time constants
	 */
	int expRandom(int param){
		Random rand = new Random();
		double n = rand.nextDouble();
		System.out.println(n);
		System.out.println(Math.log(1-n)/(-param));
		return (int) (Math.log(1-n)/(-param));
	}
	
	/*
	 * Method that returns the comfort of an Individual
	 */
	int comfort(Individual ind, int cmax, Point finalPoint, int k) {
		int ret=((1-((ind.path.cost-ind.path.getLength()+2)/((cmax-1)*ind.path.getLength()+3)))^k)*(1-(ind.currPos.getDistance(finalPoint)/(simGrid.ncols+simGrid.nrows+1)))^k;
		return ret;
	}
	
	/*
	 * Method that calls the XML parser to read the input file
	 */
	public void parseFile(String fileName){
		 SAXParserFactory fact = SAXParserFactory.newInstance();
		 fact.setValidating(true); 
		 
		 try{
			 SAXParser saxParser = fact.newSAXParser();
			 DefaultHandler handler = new XMLParser(fileName, this);
			 saxParser.parse(new File(fileName), handler);
		 } catch(IOException e) {
			 System.err.println("IO error");
		 } catch(SAXException e) {
			 System.err.println("Parser error");
		 } catch(ParserConfigurationException e) {
			 System.err.println("Parser configuration error");
		 } 
	}
	
	@Override
	public String toString() {
		String ret=currTime + "\n" + finalInst + "\n" + pop.size + "\n" + pop.maxSize + "\n" + simGrid.toString() + "\n" + comfortSens + "\n" + "\n" + finalPoint + "\n" + nObsts + "\n" + deathP + "\n" + reprP + "\n" + moveP;
		return ret;
	}
}
