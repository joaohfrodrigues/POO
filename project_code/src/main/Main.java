package main;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import path_simulation.PathSimulation;

/*Main package: responsible for reading the input file
 * Arguments: XML file name
 */
public class Main extends DefaultHandler{
	static String fileName;
	PathSimulation pathSim;
	int finalinst;
	int maxpop;
	int comfortsens;
	int colsnb;
	int rowsnb;
	int xinitial;
	int yinitial;
	
	
	public void startDocument(){
	 System.out.println("Beginning the parsing of "+ fileName);
	}
	
	public void endDocument(){
		System.out.println("Parsing concluded");
	}
	
	public void startElement(String uri, String name, String tag, Attributes atts){
		System.out.println("Element <" + tag + "> ");
		
		if (tag.equals("simulation")) { //Begin simulation
			
		}else if (tag.equals("grid")) {
			
		}else if (tag.equals("initialpoint")) {
			
		}else if (tag.equals("finalpoint")) {
			
		}else if (tag.equals("specialcostzones")) {
			
		}else if (tag.equals("zone")) {
			
		}else if (tag.equals("obstacles")) {
			
		}else if (tag.equals("obstacle")) {
			
		}else if (tag.equals("events")) {
			
		}else if (tag.equals("death")) {
			
		}else if (tag.equals("reproduction")) {
			
		}else if (tag.equals("move")) {
			
		}else
			System.out.println("Element not recognized");
			
	}
	
	public void characters(char[]ch,int start,int length){
		System.out.println(new String(ch,start,length));
	}
	
	public static void main(String[] args) {
		System.out.println(args[0]);
		fileName=args[0];
		SAXParserFactory fact = SAXParserFactory.newInstance();
		fact.setValidating(true); 
		 
		try{
			SAXParser saxParser = fact.newSAXParser();
			DefaultHandler handler = new XMLParser(fileName);
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