package path_simulation;
import org.xml.sax.*; // Generic API for SAX
import org.xml.sax.helpers.*; // Handlers
/*
 * An XMLParser that reads the input file of the PathSimulation and creates the necessary classes and Structures
 */
public class XMLParser extends DefaultHandler{
	static String fileName;
	static PathSimulation sim;
	int xinit=1;
	int yinit=1;
	int xfinal=1;
	int yfinal=1;
	
	public XMLParser(String _fileName, PathSimulation _sim) {
		fileName=_fileName;
		sim=_sim;
	}
	
	public void startDocument(){
		//System.out.println("Beginning the parsing of "+ fileName);
	}
	
	public void endDocument(){
		//System.out.println("Parsing concluded");
	}
	
	/*
	 * Read XML file and save parameters for simulation
	 */
	public void startElement(String uri, String name, String tag, Attributes atts){
		//System.out.println("Element <" + tag + "> ");
		int len=atts.getLength();
		int i=0;
		String att;	
		
		if (tag.equals("simulation")) { //SIMULATION
			for(i=0;i<len;i++) {
				att=atts.getLocalName(i);
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
		}else if (tag.equals("grid")) { //GRID
			int ncols=0;
			int nrows=0;
			for(i=0;i<len;i++) {
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
		}else if (tag.equals("initialpoint")) { //INITIAL POINT
			for(i=0;i<len;i++) {
				att=atts.getLocalName(i);
				switch (att) {
					case "xinitial":
						xinit=Integer.parseInt(atts.getValue(i));
						break;
					case "yinitial":
						yinit=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
			sim.initPoint=sim.simGrid.grid[xinit-1][yinit-1];
		}else if (tag.equals("finalpoint")) { //FINAL POINT
			for(i=0;i<len;i++) {
				att=atts.getLocalName(i);
				switch (att) {
					case "xfinal":
						xfinal=Integer.parseInt(atts.getValue(i));
						break;
					case "yfinal":
						yfinal=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
			sim.finalPoint=sim.simGrid.grid[xfinal-1][yfinal-1];
		}else if (tag.equals("specialcostzones")) { //SPECIAL COST ZONES
			sim.nZones=Integer.parseInt(atts.getValue(0));
		}else if (tag.equals("zone")) { //SPECIAL COST ZONE
			//cost=Integer.parseInt(tag);
			for(i=0;i<len;i++) {
				att=atts.getLocalName(i);
				switch (att) {
					case "xinitial":
						xinit=Integer.parseInt(atts.getValue(i));
						break;
					case "yinitial":
						yinit=Integer.parseInt(atts.getValue(i));
						break;
					case "xfinal":
						xfinal=Integer.parseInt(atts.getValue(i));
						break;
					case "yfinal":
						yfinal=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
			//sim.simGrid.addSPEdges(xinit-1,yinit-1,xfinal-1,yfinal-1, cost);
		}else if (tag.equals("obstacles")) { //OBSTACLES
			sim.nObsts=Integer.parseInt(atts.getValue(0));
		}else if (tag.equals("obstacle")) { //OBSTACLE
			for(i=0;i<len;i++) {
				att=atts.getLocalName(i);
				switch (att) {
					case "xpos":
						xinit=Integer.parseInt(atts.getValue(i));
						break;
					case "ypos":
						yinit=Integer.parseInt(atts.getValue(i));
						break;
				}
			}
			sim.simGrid.addObstacle(xinit-1,yinit-1);
		}else if (tag.equals("events")) {
			
		}else if (tag.equals("death")) {
			sim.deathP=Integer.parseInt(atts.getValue(0));
		}else if (tag.equals("reproduction")) {
			sim.reprP=Integer.parseInt(atts.getValue(0));
		}else if (tag.equals("move")) {
			sim.moveP=Integer.parseInt(atts.getValue(0));
		}else
			System.out.println("Element not recognized");
	}
	
	/*
	 * Read the cost of the SpecialCostEdges
	 */
	public void characters(char[]ch,int start,int length){
		String aux=new String(ch,start,length);
		int cost=Integer.parseInt(aux);
		if (cost>sim.cmax)
			sim.cmax=cost;
		//System.out.println(cost);	
		sim.simGrid.addSPEdges(xinit-1,yinit-1,xfinal-1,yfinal-1, cost);
	}
}
