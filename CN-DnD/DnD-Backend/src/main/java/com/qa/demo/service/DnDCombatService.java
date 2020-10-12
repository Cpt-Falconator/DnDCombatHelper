package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.persistance.domain.Combat;
import com.qa.demo.persistance.domain.CombatRepo;

@Service
public class DnDCombatService {

	private CombatRepo cRepo;

	public DnDCombatService(CombatRepo cRepo) {
		super();
		this.cRepo = cRepo;
	}

	public void createCombat(Combat combat) {
		this.cRepo.save(combat);
	}

	public List<Combat> getAllCombat() {
		return this.cRepo.findAll();
	}

	public void deleteCombat(int id) {
		this.cRepo.deleteById(id);
	}

	public void updateCombat(Combat combat, int id) {
		Combat oldCom = this.cRepo.findById(id).get();
		// oldWood.setX(combat.getx());
		this.cRepo.save(oldCom);
	}

	public void patchCombatAC(int id, int mod) {
		Combat oldCom = this.cRepo.findById(id).get();
		oldCom.setArmorClass(oldCom.getArmorClass() + mod);
		this.cRepo.save(oldCom);
	}

	public void patchCombatHP(int id, int mod) {
		Combat oldCom = this.cRepo.findById(id).get();
		oldCom.setHealthPoints(oldCom.getHealthPoints() + mod);
		this.cRepo.save(oldCom);
	}
}
