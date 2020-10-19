package com.qa.dnd.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dnd.persistance.domain.Combat;
import com.qa.dnd.service.DnDCombatService;

@RestController
@CrossOrigin
public class DnDCombatController {

	private DnDCombatService cService;

	public DnDCombatController(DnDCombatService cService) {
		super();
		this.cService = cService;
	}

	@GetMapping("/get/allCombat")
	public ResponseEntity<List<Combat>> getAllCombat() {
		return ResponseEntity.ok(this.cService.getAllCombat());
	}

	@PostMapping("/create/combat")
	public ResponseEntity<Combat> createCombat(@RequestBody Combat combat) {
		return new ResponseEntity<Combat>(this.cService.createCombat(combat), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/combat/{id}")
	public ResponseEntity<Object> deleteCombat(@PathVariable int id) {
		if (this.cService.deleteCombat(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/patch/combatAC/{id}")
	public ResponseEntity<Combat> patchCombatAC(@PathVariable int id, @RequestBody int mod) {
		return new ResponseEntity<Combat>(this.cService.patchCombatAC(id, mod), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/patch/combatHP/{id}")
	public ResponseEntity<Combat> patchCombatHP(@PathVariable int id, @RequestBody int mod) {
		return new ResponseEntity<Combat>(this.cService.patchCombatHP(id, mod), HttpStatus.ACCEPTED);
	}

}
