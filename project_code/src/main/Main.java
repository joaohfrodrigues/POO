package main;

public class Main {
	public static void main(String[] args) {
		System.out.println(args[0]);
		XMLParser parser = new XMLParser(args[0]);
		parser.parseFile();
	}
}

