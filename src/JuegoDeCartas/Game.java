package JuegoDeCartas;

public class Game {
	private Player player1;
	private Player player2;
	private String log;
	private static final int MAX_ROUNDS = 10;
	private Player winner;
	
	public Game(String nameJ1, String nameJ2) {
		    
		dealCards();         //Conviene repartir las cartas acá o al deck pasarle los players y se reparta?
		player1 = new Player(nameJ1);
		player2 = new Player(nameJ2);
		winner  = player1;
	}
	
	//Otra forma es si tenía un mazo y creo un método splitDeck
	private void dealCards() {
		Deck deck = new Deck();
		deck.loadDeck();  
		
		for (int i = 0; i < deck.size(); i++) {
			if (i%2 == 0) {                     //Si es par le da la carta al j1 sino a j2
				player1.addCard(deck.topCard());  			
			}else{ 
				player2.addCard(deck.topCard());
			}
		}
	}
	
	//Inicio del juego
	
	public void startGame(){
		int i=0;
		
		while (i<MAX_ROUNDS && player1.getDeckSize()>0 && player2.getDeckSize()>0) {
			i++;
			System.out.println("----------Ronda: "+i+"-------------------");
			playRound(); 
		}
	}
		
	public void playRound() {
		
		Card cardJ1 = winner.topCard(); 
		Card cardJ2 = player2.topCard();
		String attr = cardJ1.getRandomAttributeName();

		System.out.println("El jugador "+winner.getName()+" selecciona competir por el atributo "+attr);
		System.out.println("La carta de "+winner.getName()+" es "+cardJ1.getName()+" con "+ attr+" "+ cardJ1.getAttributeValue(attr));
		System.out.println("La carta de "+player2.getName()+" es "+cardJ2.getName()+" con "+ attr+" "+ cardJ2.getAttributeValue(attr));
		
		if (cardJ1.getAttributeValue(attr) > cardJ2.getAttributeValue(attr)) {
			System.out.println("Ganó la ronda "+winner.getName()+".");
			winner.addCard(cardJ1);
			winner.addCard(cardJ2);
		} else if (cardJ1.getAttributeValue(attr) > cardJ2.getAttributeValue(attr)){
			System.out.println("Empataron la ronda.");
			winner.addCard(cardJ1);
			winner.addCard(cardJ2);
		} else {
			System.out.println("Ganó la ronda "+player2.getName()+".");
			player2.addCard(cardJ1);
			player2.addCard(cardJ2);
			winner = player2;
			player2 = player1;
		}
		
		System.out.println(player1.getName()+" posee ahora "+player1.getDeckSize()+" cartas y "+player2.getName()+" posee ahora "+ player2.getDeckSize()+" cartas.");
	}

}
