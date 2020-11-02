package JuegoDeCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Game {
	private Player player1;
	private Player player2; 
	private Deck deck;
	private static final int MAX_ROUNDS = 10;
	private Player handWinner;
	private Player handLooser;
	private String log;
	
	public Game(String nameJ1, String nameJ2) {
		
		deck = new Deck();
		player1 = new Player(nameJ1);
		player2 = new Player(nameJ2);    	
		handWinner  = player1;	
		handLooser  = player2;	
		log = "";
	}
	
	//Cargo el Mazo
	public void loadDeck(String path) {
        File jsonInputFile = new File(path);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray jsonCards = (JsonArray) reader.readObject().getJsonArray("cartas");
                                  
            JsonObject card = jsonCards.getValuesAs(JsonObject.class).get(0);
            deck.addCard(genCard(card));        
                      
            for (int i = 1; i < jsonCards.size() ; i++) {
            	JsonObject newCard = jsonCards.getValuesAs(JsonObject.class).get(i);
            	deck.addCardCriterio(genCard(newCard));
			}                      
            reader.close();
            deck.shuffle();
      
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
	//Genera una carta
	private Card genCard(JsonObject carta) {
		Card c1 = new Card(carta.getString("nombre"));
  
        JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
        for (String nombreAtributo:atributos.keySet()) 
        	c1.addAttribute(new Attribute(nombreAtributo, atributos.getInt(nombreAtributo)));
        
        return c1;        
	}	
	
	//Reparte cartas
	private void dealCards() {
		int tam = deck.size();
		for (int i = 0; i < tam ; i++) { //Si es par le da la carta al j1 sino a j2 
			if (i%2 == 0) { 
				player1.addCard(deck.removeTopCard());
			}else{
				player2.addCard(deck.removeTopCard()); 
			}
		}
	}
	
	//Inicio del juego
	
	public void startGame(){
		  dealCards();	
		  
		  int i=0;
		  while (i<MAX_ROUNDS && player1.deckSize()>0 && player2.deckSize()>0) {
			  i++; 
			  log += "---------------------------Ronda: " + i + "--------------------------------\n\n";			  
			  playRound(); 
		  }
		  
		  checkWinner();
	}
		
	private void playRound() {
		
		String attWinner = handWinner.getRandomAttribute();
		log += "El jugador " + handWinner + " selecciona competir por el atributo " + attWinner + "\n";
		log += "La carta de " + handWinner + " es " + handWinner.topCard() + " con " + attWinner + " " + handWinner.topCard().getAttributeValue(attWinner) + "\n";		
		log += "La carta de " + handLooser + " es " + handLooser.topCard() + " con " + attWinner + " " + handLooser.topCard().getAttributeValue(attWinner) + "\n";
		
		combat(attWinner);
	}

	
	private void combat(String att) {
		int valueWinner = handWinner.topCard().getAttributeValue(att); 
		int valueLooser = handLooser.topCard().getAttributeValue(att); 
		
		if (valueWinner > valueLooser) {
				resolveWinner();
		} else {
			if (valueWinner < valueLooser) {		
				Player aux = handWinner;
				handWinner = handLooser; 
				handLooser = aux;
				resolveWinner();
			} else {
				resolveTie();
			}				
		}
		log += handWinner + " posee ahora " + handWinner.deckSize() + " cartas y " + handLooser + " posee ahora " + handLooser.deckSize() + " cartas.\n\n";
		
	}
	
	private void resolveWinner() {
		handWinner.addCard(handWinner.removeTopCard());
		handWinner.addCard(handLooser.removeTopCard());
		
		log += "Gana la ronda " + handWinner + ".\n";
	}
	
    private void resolveTie() {
    	handLooser.addCard(handLooser.removeTopCard());
    	handWinner.addCard(handWinner.removeTopCard());
		
		log += "Empataron la ronda.\n";
    }
    
    private void checkWinner() {
    	log += "---------------------------Resultado--------------------------------\n\n";			
    	if (player1.deckSize() > player2.deckSize()) {
    		log  += player1 + " ganó el juego.\n";
    	} else {
    		if (player1.deckSize() < player2.deckSize()) {
    			log  += player2 + " ganó el juego.\n";
    		} else { 
    			log  += "Empataron el juego.\n";
    		}
    	}   		
    }
    
    public String getLog() {
    	return log;
    }
			
}
