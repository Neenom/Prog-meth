package logic;

public class CardCounter {
	private UnitCard card;
	private int count;

	public CardCounter(UnitCard card, int count) {
		this.card = card;
		setCount(count);
	}

	public void setCount(int count) {
		this.count = Math.max(0, count);
	}

	public UnitCard getCard() {
		return card;
	}

	public void setCard(UnitCard card) {
		this.card = card;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return card.toString() + " x " + count;
	}
}
