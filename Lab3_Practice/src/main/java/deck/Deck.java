package deck;


import java.util.Arrays;

import card.base.Card;


public class Deck {
	private String name;
	private  int deckSize;
	private Card[] deckList;
	
	public Deck(String name, Card[] deckList) {
		this.name =name;
		this.deckList = deckList;
		this.setDeckSize(deckList.length);
	}
	//You CAN modify the first line
		public int insertCard(Card card) throws InsertCardFailedException{
			int count = 0;
			for(Card cc:deckList){
				if(cc.equals(card))count++;
			}

			if(count >= 4) 
				throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
			//FILL CODE HERE
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
			//Must return new deckSize
			Card[] nwdeck = Arrays.copyOf(deckList,deckSize+1);
			nwdeck[deckSize] = card;
			setDeckSize(nwdeck.length);
			this.deckList=nwdeck;
			return deckSize;



		}

		//You CAN modify the first line
		public Card removeCard(int slotNumber) throws RemoveCardFailedException {
			if (this.deckList.length <= slotNumber) {
				throw new RemoveCardFailedException("Number you insert exceed deck size");
			}		
			if (this.deckList[slotNumber] == null) {
				throw new RemoveCardFailedException("There is no card in that slot");
			}
			Card x = deckList[slotNumber];
			for(int i=slotNumber+1;i<getDeckSize();i++){
				deckList[i-1]=deckList[i];
			}
			Card[] nwdeck = Arrays.copyOf(deckList,deckSize-1);
			setDeckSize(nwdeck.length);
			this.deckList =nwdeck;
			return  x;
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
			//Once card is removed, other card down the list must rearrange to the empty slot
			//Must return card that was removed
		}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}

	public String getName() {
		return name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

}
