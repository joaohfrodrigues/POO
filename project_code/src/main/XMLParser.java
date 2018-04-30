package main;
import javax.xml.parsers.*; // SAX and DOM parsers
import org.xml.sax.*; // Generic API for SAX
import org.xml.sax.helpers.*; // Handlers 
import java.io.*;

public class XMLParser extends DefaultHandler{
	static String fileName;
	
	public XMLParser(String _fileName) {
		fileName=_fileName;
	}
	
	public void startDocument(){
	 System.out.println("Beginning the parsing of "+ fileName);
	}
	
	public void endDocument(){
		System.out.println("Parsing concluded");
	}
	
	public void startElement(String uri, String name, String tag, Attributes atts){
		System.out.println("Element <" + tag + "> ");
		
		if (tag.equals("simulation")) {
			
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
	
	public void parseFile(){
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
