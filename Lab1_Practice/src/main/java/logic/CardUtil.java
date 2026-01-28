package logic;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for(UnitCard l :list){
			if(l==card){
				return true;
			}
		}



		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for(UnitDeck l : list){
			if(l==deck){
				return true;
			}
		}
		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for(UnitDeck l : deckList){
			if(l.existsInDeck(cardToTest)){
				return true;
			}
		}

		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename) throws IOException {
		
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);
		Scanner myReader = new Scanner(inputStream);
		try {
			if (inputStream == null) {
				System.out.println("Cannot find file!");
				return null;
			}



			while (myReader.hasNextLine()){
				String line = myReader.nextLine();
				String[] data= line.split(",");

				if(data.length !=5){
					throw new Exception();
				}
					String name =data[0];
					int bloodCost = Integer.parseInt(data[1]);
					int power = Integer.parseInt(data[2]);
					int health =Integer.parseInt(data[3]);
					String flavorText =data[4];

					UnitCard card = new UnitCard(name,bloodCost,power,health,flavorText);
					cardsFromFile.add(card);
					return cardsFromFile;

			}
		} catch (Exception e) {
			System.out.println("File contains string with incorrect format!");
			return null;
        }
		finally {
            assert inputStream != null;
            inputStream.close();
		}


        return null;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().isEmpty()) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}
}
