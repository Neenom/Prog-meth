package logic;

import java.util.ArrayList;

public class UnitDeck {
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    public UnitDeck(String deckName) {
        cardsInDeck = new ArrayList<>();
        setDeckName(deckName);
    }

    public void setDeckName(String deckName) {
        if (deckName == null || deckName.isBlank()) {
            this.deckName = "Untitled Deck";
        } else {
            this.deckName = deckName;
        }
    }

    public String getDeckName() {
        return deckName;
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }

    public void addCard(UnitCard newCard, int count) {
        if (count <= 0) return;

        for (CardCounter cc : cardsInDeck) {
            if (cc.getCard().equals(newCard)) {
                cc.setCount(cc.getCount() + count);
                return;
            }
        }
        cardsInDeck.add(new CardCounter(newCard, count));
    }

    public void removeCard(UnitCard toRemove, int count) {
        if (count <= 0) return;

        for (int i = 0; i < cardsInDeck.size(); i++) {
            CardCounter cc = cardsInDeck.get(i);
            if (cc.getCard().equals(toRemove)) {
                cc.setCount(cc.getCount() - count);
                if (cc.getCount() <= 0) {
                    cardsInDeck.remove(i);
                }
                return;
            }
        }
    }

    public int cardCount() {
        int total = 0;
        for (CardCounter cc : cardsInDeck) {
            total += cc.getCount();
        }
        return total;
    }

    public boolean existsInDeck(UnitCard card) {
        for (CardCounter cc : cardsInDeck) {
            if (cc.getCard().equals(card) && cc.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(UnitDeck other) {
        if (other == null) return false;
        return this.deckName.equals(other.deckName);
    }

    @Override
    public String toString() {
        return deckName;
    }
}
