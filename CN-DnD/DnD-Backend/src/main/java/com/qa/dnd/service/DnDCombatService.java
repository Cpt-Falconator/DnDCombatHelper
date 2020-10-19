package com.qa.dnd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dnd.persistance.domain.Combat;
import com.qa.dnd.persistance.domain.CombatRepo;

@Service
public class DnDCombatService {

	private CombatRepo cRepo;

	public DnDCombatService(CombatRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	public Combat createCombat(Combat combat) {
		return this.cRepo.save(combat);
	}

	public List<Combat> getAllCombat() {
		return this.cRepo.findAll();
	}

	public boolean deleteCombat(int id) {
		if (this.cRepo.existsById(id)) {
			this.cRepo.deleteById(id);
			return !this.cRepo.existsById(id);
		} else {
			return false;
		}
	}

	public Combat patchCombatAC(int id, int mod) {
		Combat oldCom = this.cRepo.findById(id).get();
		oldCom.setArmorClass(oldCom.getArmorClass() + mod);
		return this.cRepo.save(oldCom);
	}

	public Combat patchCombatHP(int id, int mod) {
		Combat oldCom = this.cRepo.findById(id).get();
		oldCom.setHealthPoints(oldCom.getHealthPoints() + mod);
		return this.cRepo.save(oldCom);
	}
}
