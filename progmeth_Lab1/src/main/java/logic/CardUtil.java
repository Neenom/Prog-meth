package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for (UnitCard c : list) {
			if (c.equals(card)) return true;
		}
		return false;
	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for (UnitDeck d : list) {
			if (d.equals(deck)) return true;
		}
		return false;
	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		for (UnitDeck deck : deckList) {
			if (deck.existsInDeck(cardToTest)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {
		ArrayList<UnitCard> cardsFromFile = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(",");

				if (parts.length != 5) {
					System.out.println("File contains string with incorrect format!");
					sc.close();
					return null;
				}

				UnitCard card = new UnitCard(
						parts[0].trim(),
						Integer.parseInt(parts[1].trim()),
						Integer.parseInt(parts[2].trim()),
						Integer.parseInt(parts[3].trim()),
						parts[4].trim()
				);
				cardsFromFile.add(card);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("File contains string with incorrect format!");
			return null;
		}

		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		for (UnitCard card : cardList) {
			System.out.println(card);
			System.out.println("Blood Cost: " + card.getBloodCost());
			if (verbose) {
				System.out.println(card.getFlavorText());
			}
		}
	}

	public static void printDeck(UnitDeck ud) {
		for (CardCounter cc : ud.getCardsInDeck()) {
			System.out.println(cc);
		}
		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		for (UnitDeck deck : deckList) {
			System.out.println(deck.getDeckName());
			printDeck(deck);
			System.out.println("-----");
		}
	}
}
