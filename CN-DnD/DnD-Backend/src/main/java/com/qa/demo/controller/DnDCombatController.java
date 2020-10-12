package com.qa.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.persistance.domain.Combat;
import com.qa.demo.service.DnDCombatService;

@RestController
@CrossOrigin
public class DnDCombatController {

	private DnDCombatService cService;

	public DnDCombatController(DnDCombatService cService) {
		super();
		this.cService = cService;
	}

	@GetMapping("/get/allCombat")
	public List<Combat> getAllCombat() {
		return this.cService.getAllCombat();
	}

	@PostMapping("/create/combat")
	public void createCombat(@RequestBody Combat combat) {
		this.cService.createCombat(combat);
	}

	@DeleteMapping("/delete/combat/{id}")
	public void deleteCombat(@PathVariable int id) {
		this.cService.deleteCombat(id);
	}

}
