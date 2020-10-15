package com.qa.dnd.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Combat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int initiative;

	private String name;

	private int armorClass;

	private int healthPoints;

	private int maxHealthPoints;

	private boolean player;

	public Combat() {
		super();
	}

	public Combat(int initiative, String name, int armorClass, int healthPoints, int maxHealthPoints,
			boolean isPlayer) {
		super();
		setInitiative(initiative);
		setName(name);
		setArmorClass(armorClass);
		setHealthPoints(healthPoints);
		setMaxHealthPoints(maxHealthPoints);
		setPlayer(isPlayer);
	}

	public boolean isPlayer() {
		return player;
	}

	public void setPlayer(boolean isPlayer) {
		this.player = isPlayer;
	}

	public int getMaxHealthPoints() {
		return maxHealthPoints;
	}

	public void setMaxHealthPoints(int maxHealthPoints) {
		this.maxHealthPoints = maxHealthPoints;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInitiative() {
		return initiative;
	}

	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + initiative;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + armorClass;
		result = prime * result + healthPoints;
		result = prime * result + maxHealthPoints;
		result = prime * result + (player ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combat other = (Combat) obj;
		if (initiative != other.initiative)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (armorClass != other.armorClass)
			return false;
		if (healthPoints != other.healthPoints)
			return false;
		if (maxHealthPoints != other.maxHealthPoints)
			return false;
		if (player != other.player)
			return false;
		return true;
	}

}
