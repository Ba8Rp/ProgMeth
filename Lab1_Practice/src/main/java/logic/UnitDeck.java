package logic;
import java.util.ArrayList;
import java.util.Objects;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName ;

    public UnitDeck(String deckName) {
        this.cardsInDeck = new ArrayList<>();
       this.setDeckName(deckName);
    }

    public void addCard (UnitCard newCard , int count){
        if(count<= 0)return;

        for(CardCounter cc:cardsInDeck){

            if(cc.getCard()==newCard){
                cc.setCount(cc.getCount()+count);
                return;
            }
        }

    CardCounter newCardCounter = new CardCounter(newCard,count);

        cardsInDeck.add(newCardCounter);


    }
    public void removeCard (UnitCard toRemove, int count){
        if(count<= 0)return;

        for(CardCounter cc:cardsInDeck){
            if(cc.getCard()==toRemove){
                int newCount = cc.getCount()-count;

                if(newCount>0){
                    cc.setCount(newCount);
                }else{
                    cardsInDeck.remove(cc);
                }
                return;
            }
        }

    }
    public int cardCount(){
        int sum=0;
        for(CardCounter cc : cardsInDeck){
            sum+=cc.getCount();
        }
        return sum;

    }
    public boolean existsInDeck(UnitCard card){
        for(CardCounter cc:cardsInDeck){
            if(cc.getCard()==card &&cc.getCount()>=1){
                return true;
            }
        }
        return false;
    }


    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitDeck other = (UnitDeck) o;
        return (Objects.equals(getDeckName(), other.getDeckName()));
    }


    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        if(deckName.isBlank()){
            this.deckName="Untitled Deck";
        }else{
            this.deckName=deckName;
        }
    }
}
