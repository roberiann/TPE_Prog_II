package JuegoDeCartas;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game("Tomas", "Roberto");
		
		String path = "./src/JuegoDeCartas/superheroes.json";
		game.loadDeck(path);
		
		game.startGame();
		
		System.out.println(game.getLog());
	}

}
