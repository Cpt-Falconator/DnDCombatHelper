package com.qa.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.persistance.domain.Combat;

@Service
public class DnDCombatService {
	private List<Combat> combatDB = new ArrayList();

	public void createCombat(Combat combat) {
		this.combatDB.add(combat);
	}

	public List<Combat> getAllCombat() {
		return this.combatDB;
	}

	public void deleteCombat(int id) {
		this.combatDB.remove(id);
	}
}
