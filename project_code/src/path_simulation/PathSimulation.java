package path_simulation;
import java.io.File;
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
	int initPop;
	int maxPop;
	Grid simGrid;
	int comfortSens;
	
	public void setupSimulation(String fileName) {
		this.parseFile(fileName);
		currTime=0;
		System.out.println("currTime = " + currTime);
		System.out.println("finalInst = " + finalInst);
		System.out.println("initPop= " + initPop);
		System.out.println("maxPop = " + maxPop);
		System.out.println("comfortSens = " + comfortSens);
		
		System.out.println("Grid: \n" + simGrid);
	}
	
	public void initSimulation() {
		
	}
	
	public void stopSimulation() {
		
	}
	
	//Method that returns a random variable between two numbers, according to some time constants
	int expRandom(){
		return 0;
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
}
