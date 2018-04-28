package simulation;

public class TestingMain {

	public static void main(String[] args) {
		PEC pecinho = new PEC();
		
		pecinho.addEvPEC(new Death(10, 3));
		pecinho.addEvPEC(new Move(5, 2));
		pecinho.addEvPEC(new Reproduction(7, 8));
		
		System.out.println(pecinho);
		
		Event next= pecinho.nextEvPEC();
		
		System.out.println(next);
		System.out.println("\n");
		System.out.println(pecinho);
	}

}
