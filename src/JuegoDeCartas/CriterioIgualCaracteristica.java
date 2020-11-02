package JuegoDeCartas;

public class CriterioIgualCaracteristica extends Criterio{
    private Card card;
    

    public CriterioIgualCaracteristica(Card card){
        this.card = card;
    }

    @Override
    public boolean cumple(Card c) {        
    	return (c.sizeAttributes() == card.sizeAttributes() &&  card.sameAttributes(c));         
    }
}
