package path_simulation;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import pec.Event;
import pec.PEC;
/*
 * Path Simulator. Includes the Pending Event Container, current time and simulation time
 * and the population of individuals
 */
public class PathSimulation extends AbsSimulation{
	double currTime;
	double finalInst;
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
	double bestComfort;
	Population pop;
	int initPop=0;
	int maxPop=0;
	int cmax=0; //maximum cost of an edge in the grid
	int nbEvents=0;
	PEC pec = new PEC();
	
	public void setupSimulation(String fileName) {
		this.parseFile(fileName); //Read File
		currTime=0;
		
		/*
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
		*/
		
		/*POPULATION*/
		pop=new Population(maxPop);
		
		/*INDIVIDUALS AND EVENTS*/
		for(double t=0; t<finalInst; t=t+finalInst/20)
			pec.addEvPEC(new Observation(t, this));
		
		for(int i=0;i<initPop;i++) {
			Individual ind = new Individual(initPoint);
			initInd(ind);
		}
		
		//System.out.println(pec);
	}
	
	public void initSimulation() {
		Event currEvent=pec.nextEvPEC();

		while(currEvent != null && currTime < finalInst) {
			nbEvents++;
			currTime = currEvent.getTime();
			//System.out.println();
			//System.out.println(currEvent);
			//System.out.println();
			currEvent.simulateEvent();
			try {
				//TimeUnit.SECONDS.sleep(1);
			}catch(Exception e){
				
			}
			currEvent=pec.nextEvPEC();
		}
	}
	
	public void stopSimulation() {
		
	}
	
	void initInd(Individual ind) {
		/*calculate time of death, first reproduction and first move*/
		double tDeath = currTime + setTime(ind, deathP);
		double tMove = currTime + setTime(ind, moveP);
		double tRep = currTime + setTime(ind, reprP);
		//System.out.println("tDeath = " + tDeath + " tMove = " + tMove + " tRep= " + tRep);
		ind.setDeath(tDeath);
		
		pec.addEvPEC(new Death(tDeath, ind, pop));
		
		if(tMove < tDeath)
			pec.addEvPEC(new Move(tMove, ind, this));

		if(tRep < tDeath)
			pec.addEvPEC(new Reproduction(tRep, ind, this));
		
		pop.addIndividual(ind);
	}
	
	//Method that returns a random variable between two numbers, according to some time constants
	double expRandom(double mean){				
		Random rand = new Random();
		double ret = rand.nextDouble();
		ret = -mean*Math.log(1-ret);
		return ret;
	}
	
	/*
	 * Method that returns the comfort of an Individual
	 */
	double setComfort(Individual ind) {
		int dist = finalPoint.getDistance(ind.currPos);
		double comf = (1.0 - (ind.path.cost-ind.path.getLength()+2.0)/((cmax-1.0)*ind.path.getLength()+3.0));
		comf *= (1.0 - dist/(simGrid.ncols + simGrid.nrows +1.0));
		comf = Math.pow(comf, comfortSens);
		ind.setComf(comf);
		return comf;
	}
	
	double calcMean(double comf, int p) {
		return (1 - Math.log(1 - comf))*p;
	}
	
	double setTime(Individual ind, int p) {
		return expRandom(calcMean(setComfort(ind), p));
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
