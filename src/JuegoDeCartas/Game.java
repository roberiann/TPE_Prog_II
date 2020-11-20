package JuegoDeCartas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import Aditivos.Potion;

public class Game {
	private Player player1;
	private Player player2; 
	private Deck deck;
	private int maxRounds;
	private Player handWinner;
	private Player handLooser;
	private String log;
	private ArrayList<Potion> potions;
	
	public Game(Player p1, Player p2, int maxRounds) {
		
		this.maxRounds = maxRounds;
		deck = new Deck();
		player1 = p1;
		player2 = p2;    	
		handWinner  = player1;	
		handLooser  = player2;	
		log = "";
		potions = new ArrayList<Potion>();
	}
	
	public void addPotion(Potion potion) {
		potions.add(potion);
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
                                                     
            for (int i = 0; i < jsonCards.size() ; i++) {
            	JsonObject card = jsonCards.getValuesAs(JsonObject.class).get(i);
            	deck.addCard(genCard(card));
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
		Collections.shuffle(potions);
		
		for (int i = 0; i < tam ; i++) { //Si es par le da la carta al j1 sino a j2
			Card card = deck.removeTopCard();
			if (!potions.isEmpty())
				card.setPotion(potions.remove(0));
			
			if (i%2 == 0) { 				
   			    player1.addCard(card);
			}else{
				player2.addCard(card); 
			}
		}
		player1.shuffle();
		player2.shuffle();
	}
	
	//Inicio del juego
	
	public void startGame(){
		  dealCards();	
		  
		  int i=0;
		  while (i<maxRounds && player1.deckSize()>0 && player2.deckSize()>0) {
			  i++; 
			  log += "---------------------------Ronda: " + i + "--------------------------------\n\n";			  
			  playRound(); 
		  }
		  
		  checkWinner();
	}
		
	private void playRound() {
		
		String attWinner = handWinner.getAttribute();
		log += "El jugador " + handWinner + " selecciona competir por el atributo " + attWinner + "\n";
		
		Card c1 = handWinner.topCard();
		Card c2 = handLooser.topCard();
		
		log += "La carta de " + handWinner + " es " + c1 + " con " + attWinner + " " + c1.getAttValue(attWinner);
		log += c1.getLog(attWinner);
		
		log += "La carta de " + handLooser + " es " + c2 + " con " + attWinner + " " + c2.getAttValue(attWinner);
		log += c2.getLog(attWinner);
		
		combat(c1, c2, attWinner);		
	}

	
	private void combat(Card c1, Card c2, String att) {
		
		if (c1.compareTo(c2, att) > 0) {
				resolveWinner();
		} else {
			if (c1.compareTo(c2, att) < 0) {		
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
    		log  += player1 + " gan� el juego.\n";
    	} else {
    		if (player1.deckSize() < player2.deckSize()) {
    			log  += player2 + " gan� el juego.\n";
    		} else { 
    			log  += "Empataron el juego.\n";
    		}
    	}   		
    }
    
    public String getLog() {
    	return log;
    }
			
}
