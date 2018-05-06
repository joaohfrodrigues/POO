package path_simulation;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import simulation.Simulation;

import java.util.concurrent.ThreadLocalRandom;
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
	
	public void setupSimulation(String fileName) {
		//Read File
		this.parseFile(fileName);
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
		for(int i=0;i<initPop;i++)
			pop.addIndividual(new Individual(initPoint));
		
		System.out.println(pop);
	}
	
	public void initSimulation() {
		
	}
	
	public void stopSimulation() {
		
	}
	
	//Method that returns a random variable between two numbers, according to some time constants
	int expRandom(int min, int max){		
		int randomNum = ThreadLocalRandom.current().nextInt(min, max);
	    return randomNum;
	}
	
	int comfort(Individual ind, int cmax, Point finalPoint, int k, Grid grid) {
		int cost = ind.path.cost;
		int len_p = ind.path.getLength();
		
		int dist = finalPoint.column - ind.currPos.column;
		dist += finalPoint.row - ind.currPos.row;
		
		int comf = (1 - (cost-len_p+2)/((cmax-1)*len_p+3))^k;
		comf *= (1 - dist/(grid.ncols + grid.nrows +1))^k;
		
		return comf;
	}
	
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
