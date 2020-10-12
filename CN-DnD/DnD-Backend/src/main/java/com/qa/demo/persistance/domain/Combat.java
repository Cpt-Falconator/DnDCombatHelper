package com.qa.demo.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Combat {

	@Id
	@GeneratedValue
	private int id;

	private int initiative;

	private String name;

	private int armorClass;

	private int healthPoints;

	private int maxHealthPoints;

	private boolean isPlayer;

	public Combat() {
		super();
	}

	public Combat(int initiative, String name, int armorClass, int healthPoints, int maxHealthPoints,
			boolean isPlayer) {
		super();
		this.initiative = initiative;
		this.name = name;
		this.armorClass = armorClass;
		this.healthPoints = healthPoints;
		this.maxHealthPoints = maxHealthPoints;
		this.isPlayer = isPlayer;
	}

	public boolean isPlayer() {
		return isPlayer;
	}

	public void setPlayer(boolean isPlayer) {
		this.isPlayer = isPlayer;
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

	public void getId(int id) {
		this.id = id;
	}

}
