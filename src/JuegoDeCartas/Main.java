package JuegoDeCartas;

import Aditivos.PotionAttribute;
import Aditivos.PotionCocktail;
import Aditivos.PotionPercentage;
import Aditivos.PotionValue;
import Estrategias.Ambitious;
import Estrategias.Obstinate;
import Estrategias.Random;
import Estrategias.Strategy;


public class Main {

	public static void main(String[] args) {
		

		// 1er Mazo		
		Strategy obstinado = new Obstinate("fuerza");
		Strategy ambitious = new Ambitious();
	
		Player p1 = new Player("Tomas", obstinado);
		Player p2 = new Player("Roberto", ambitious);
		
		Game game = new Game(p1, p2, 10);
		
		String path = "./src/JuegoDeCartas/superheroes.json";
		game.loadDeck(path);
	 
	    PotionPercentage fortalecedora = new PotionPercentage("Fortalecedora", 1.2);  
		PotionPercentage fortalecedora2 = new PotionPercentage("Fortalecedora", 1.2);
		PotionPercentage fortalecedoraPlus = new PotionPercentage("Fortalecedora Plus", 1.5); 
		PotionPercentage kriptonita = new PotionPercentage("kriptonita", 0.75);
		PotionPercentage kriptonita2 = new PotionPercentage("kriptonita", 0.75);
		PotionPercentage reductoraPlomo = new PotionPercentage("Reductora de plomo", 0.45);
		PotionPercentage reductoraPlomo2 = new PotionPercentage("Reductora de plomo", 0.45);
		PotionValue valeCuatro = new PotionValue("Quiero vale 4", 4);
		PotionValue nroMagico = new PotionValue("Número Mágico", 23);
		PotionAttribute selectivaPeso = new PotionAttribute("Selectiva Peso", 1.43, "peso");
		PotionAttribute selectivaPeso2 = new PotionAttribute("Selectiva Peso", 1.43, "peso");
		PotionAttribute selectivaFuerza = new PotionAttribute("Selectiva Fuerza", 1.35, "fuerza");
		PotionAttribute selectivaFuerza2 = new PotionAttribute("Selectiva Fuerza", 1.35, "fuerza");
		
		PotionCocktail pocimaCocktail = new PotionCocktail("Cocktail");
		pocimaCocktail.addCocktail(fortalecedora2);
		pocimaCocktail.addCocktail(kriptonita2);
	    
		
		PotionCocktail pocimaCocktail2 = new PotionCocktail("Cocktail2");
		pocimaCocktail2.addCocktail(reductoraPlomo2);
		pocimaCocktail2.addCocktail(selectivaPeso);
		pocimaCocktail2.addCocktail(pocimaCocktail);
		
		
		game.addPotion(fortalecedora); game.addPotion(fortalecedoraPlus);
		game.addPotion(kriptonita); game.addPotion(reductoraPlomo);
		game.addPotion(valeCuatro); game.addPotion(nroMagico);
		game.addPotion(selectivaPeso); game.addPotion(selectivaPeso2);
		game.addPotion(selectivaFuerza); game.addPotion(selectivaFuerza2);
		 
		game.addPotion(pocimaCocktail2);  
		
		
       // 2do Mazo 		
		
	/*	Strategy ambitious = new Ambitious();
		Strategy random = new Random();
		
		Player p1 = new Player("Tomas", random);
		Player p2 = new Player("Roberto", ambitious);
		
		Game game = new Game(p1, p2, 10);
		
        PotionPercentage fortalecedora = new PotionPercentage("Fortalecedora", 1.2);  
		PotionPercentage kriptonita = new PotionPercentage("kriptonita", 0.75);
		PotionPercentage reductoraPlomo = new PotionPercentage("Reductora de plomo", 0.45);
		PotionValue valeCuatro = new PotionValue("Quiero vale 4", 4);
		PotionValue nroMagico = new PotionValue("Número Mágico", 23);	
		PotionAttribute selectivaCilindros = new PotionAttribute("Selectiva Cilindros", 1.43, "Cilindros");
		PotionAttribute selectivaRPM = new PotionAttribute("Selectiva RPM", 1.35, "RPM");
		
		game.addPotion(fortalecedora);
		game.addPotion(reductoraPlomo);
		game.addPotion(valeCuatro);
		game.addPotion(nroMagico);
		game.addPotion(selectivaRPM); 
		
		PotionCocktail pocimaCocktail = new PotionCocktail("Cocktail");
		pocimaCocktail.addCocktail(kriptonita);
		pocimaCocktail.addCocktail(reductoraPlomo);
		
		PotionCocktail pocimaCocktail2 = new PotionCocktail("Cocktail2");
		pocimaCocktail2.addCocktail(nroMagico);
		pocimaCocktail2.addCocktail(selectivaCilindros);
		pocimaCocktail2.addCocktail(pocimaCocktail);
				
		game.addPotion(pocimaCocktail2);
		
		String path = "./src/JuegoDeCartas/autos.json";
		game.loadDeck(path);    */
		
		game.startGame();
		
		System.out.println(game.getLog());    
	}
}
