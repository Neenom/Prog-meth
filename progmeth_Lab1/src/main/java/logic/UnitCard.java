package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		this.flavorText = flavorText;
	}

	public void setName(String name) {
		if (name == null || name.isBlank()) {
			this.name = "Creature";
		} else {
			this.name = name;
		}
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = Math.max(0, bloodCost);
	}

	public void setPower(int power) {
		this.power = Math.max(0, power);
	}

	public void setHealth(int health) {
		this.health = Math.max(1, health);
	}

	public boolean equals(UnitCard other) {
		if (other == null) return false;
		return this.name.equals(other.name);
	}

	public String getName() {
		return name;
	}

	public int getBloodCost() {
		return bloodCost;
	}

	public int getPower() {
		return power;
	}

	public int getHealth() {
		return health;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	@Override
	public String toString() {
		return name + " (POW: " + power + ", HP: " + health + ")";
	}
}
