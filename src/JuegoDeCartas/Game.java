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
	private String log;
	private ArrayList<Potion> potions;
	
	public Game(Player p1, Player p2, int maxRounds) {
		
		this.maxRounds = maxRounds;
		deck = new Deck();
		player1 = p1;
		player2 = p2;    	
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

	//Juega la ronda
	private void playRound() {
		
		String att = player1.getAttribute();
		log += "El jugador " + player1 + " selecciona competir por el atributo " + att + "\n";
		
		Card c1 = player1.topCard();
		Card c2 = player2.topCard();
		
		log += "La carta de " + player1 + " es " + c1 + c1.getLog(att);
		log += "La carta de " + player2 + " es " + c2 + c2.getLog(att);
		
		combat(c1, c2, att);		
	}

	//Enfrenta cartas x atributo
	private void combat(Card c1, Card c2, String att) {
		
		if (c1.compareTo(c2, att) == 0) {
				resolveTie();
		} else {		
			if (c1.compareTo(c2, att) < 0) {		
				Player aux = player1;
				player1 = player2; 
				player2 = aux;
			} 
			resolveWinner();
		}
		log += player1 + " posee ahora " + player1.deckSize() + " cartas y " + player2 + " posee ahora " + player2.deckSize() + " cartas.\n\n";
		
	}
	
	private void resolveWinner() {
		player1.addCard(player1.removeTopCard());
		player1.addCard(player2.removeTopCard());
		
		log += "Gana la ronda " + player1 + ".\n";
	}
	
    private void resolveTie() {
    	player2.addCard(player2.removeTopCard());
    	player1.addCard(player1.removeTopCard());
		
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
