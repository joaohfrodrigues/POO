package path_simulation;

import org.xml.sax.*; // Generic API for SAX
import org.xml.sax.helpers.*; // Handlers

public class XMLParser extends DefaultHandler{
	static String fileName;
	static PathSimulation sim;
	
	public XMLParser(String _fileName, PathSimulation _sim) {
		fileName=_fileName;
		sim=_sim;
	}
	
	public void startDocument(){
	 System.out.println("Beginning the parsing of "+ fileName);
	}
	
	public void endDocument(){
		System.out.println("Parsing concluded");
	}
	
	public void startElement(String uri, String name, String tag, Attributes atts){
		//System.out.println("Element <" + tag + "> ");
		int len=atts.getLength();
		String att;
		
		if (tag.equals("simulation")) {
			for(int i=0;i<len;i++) {
				att=atts.getLocalName(i);
				System.out.println(att);
				switch (att) {
					case "finalinst":
						sim.finalInst=Integer.parseInt(atts.getValue(i));
						break;
					case "initpop":
						sim.initPop=Integer.parseInt(atts.getValue(i));
						break;
					case "maxpop":
						sim.maxPop=Integer.parseInt(atts.getValue(i));
						break;
					case "comfortsens":
						sim.comfortSens=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
		}else if (tag.equals("grid")) {
			int ncols=0;
			int nrows=0;
			for(int i=0;i<len;i++) {
				att=atts.getLocalName(i);
				switch (att) {
					case "colsnb":
						ncols=Integer.parseInt(atts.getValue(i));
						break;
					case "rowsnb":
						nrows=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
			sim.simGrid=new Grid(ncols,nrows);
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
		//System.out.println(new String(ch,start,length));
	}
}
