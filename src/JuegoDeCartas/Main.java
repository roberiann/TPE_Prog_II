package JuegoDeCartas;

import Aditivos.Potion;
import Aditivos.PotionAttribute;
import Aditivos.PotionCocktail;
import Aditivos.PotionPercentage;
import Aditivos.PotionValue;
import Estrategias.Ambitious;
import Estrategias.Obstinate;
import Estrategias.Strategy;


public class Main {

	public static void main(String[] args) {
		
		Strategy timbero = new Obstinate();
		Strategy ambitious = new Ambitious();
		
		Player p1 = new Player("Tomas", timbero);
		Player p2 = new Player("Roberto", ambitious);
		
		Game game = new Game(p1, p2, 10);
		
		Potion fortalecedora = new PotionPercentage("Fortalecedora", 1.2); 
		Potion fortalecedora2 = new PotionPercentage("Fortalecedora", 1.2);
		Potion fortalecedoraPlus = new PotionPercentage("Fortalecedora Plus", 1.5); 
		Potion fortalecedoraPlus2 = new PotionPercentage("Fortalecedora Plus", 1.5);
		Potion kriptonita = new PotionPercentage("kriptonita", 0.75);
		Potion kriptonita2 = new PotionPercentage("kriptonita", 0.75);
		Potion reductoraPlomo = new PotionPercentage("Reductora de plomo", 0.45);
		Potion reductoraPlomo2 = new PotionPercentage("Reductora de plomo", 0.45);
		Potion valeCuatro = new PotionValue("Quiero vale 4", 4);
		Potion valeCuatro2 = new PotionValue("Quiero vale 4", 4);
		Potion nroMagico = new PotionValue("Número Mágico", 23);
		Potion nroMagico2 = new PotionValue("Número Mágico", 23);
		Potion selectivaPeso = new PotionAttribute("Selectiva Peso", 1.43, "peso");
		Potion selectivaPeso2 = new PotionAttribute("Selectiva Peso", 1.43, "peso");
		Potion selectivaFuerza = new PotionAttribute("Selectiva Fuerza", 1.35, "fuerza");
		Potion selectivaFuerza2 = new PotionAttribute("Selectiva Fuerza", 1.35, "fuerza");
		
		PotionCocktail pocimaCocktail   = new PotionCocktail("Cocktail");
		pocimaCocktail.addCocktail(fortalecedora2);
		pocimaCocktail.addCocktail(fortalecedoraPlus2);
		pocimaCocktail.addCocktail(kriptonita2);
		
		PotionCocktail pocimaCocktail2   = new PotionCocktail("Cocktail");
		pocimaCocktail2.addCocktail(reductoraPlomo2);
		pocimaCocktail2.addCocktail(valeCuatro2);
		pocimaCocktail2.addCocktail(nroMagico2);
		
		game.addPotion(fortalecedora); game.addPotion(fortalecedoraPlus);
		game.addPotion(kriptonita); game.addPotion(reductoraPlomo);
		game.addPotion(valeCuatro); game.addPotion(nroMagico);
		game.addPotion(selectivaPeso); game.addPotion(selectivaPeso2);
		game.addPotion(selectivaFuerza); game.addPotion(selectivaFuerza2);
		
		game.addPotion(pocimaCocktail);
		game.addPotion(pocimaCocktail2);
		
		
		String path = "./src/JuegoDeCartas/superheroes.json";
		game.loadDeck(path);
		
		
		game.startGame();
		
		System.out.println(game.getLog());
	}
}
