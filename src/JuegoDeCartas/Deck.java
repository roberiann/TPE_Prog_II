package JuegoDeCartas;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Deck {
	private static final String PATH = "./src/JuegoDeCartas/superheroes.json"; //PREGUNTAR
	private ArrayList<Card> cards;
		
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public void loadDeck() {
		
	    //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(PATH);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray jsonCards = (JsonArray) reader.readObject().getJsonArray("cartas");
            
            Card  firstCard = null;                  // Necesitamos validar si el json está vaci??
            if (!jsonCards.isEmpty()){
            	firstCard = new Card(jsonCards.get(0).asJsonObject());
            	jsonCards.remove(0);
            }
            
            cards.add(firstCard);
            
            for (JsonObject card : jsonCards.getValuesAs(JsonObject.class)) {
            	Card  newCard = new Card(card);
            	
            	if (newCard.sameAttributes(firstCard)&&firstCard.sameAttributes(newCard)) {  //Conviene definir equals de cartas por los atributos?
            		 cards.add(newCard);
            	}
            }

            reader.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    
    //ESTA BIEN QUE UN MAZO PUEDA CARGARSE O BIEN DESDE EL ARCHIVO O BIEN PASARLE CARTAS
    public void addCard(Card c) {
    	cards.add(c);
    }
        
	public Card topCard() {
		if (!cards.isEmpty()) {
			return cards.remove(0);
		} else {
			return null;
		}	
	}
	
	public String topCardName() {
		if (!cards.isEmpty()) {
			return cards.get(0).getName();
		} else {
			return "";
		}
	}	

	public boolean isEmpty() {
		return cards.size()==0;
	}

	public int size() {
		return cards.size();
	}

}
