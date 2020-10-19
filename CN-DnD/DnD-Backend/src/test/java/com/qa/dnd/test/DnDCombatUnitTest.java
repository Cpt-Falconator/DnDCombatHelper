package com.qa.dnd.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.dnd.persistance.domain.Combat;
import com.qa.dnd.persistance.domain.CombatRepo;
import com.qa.dnd.service.DnDCombatService;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class DnDCombatUnitTest {

	@Autowired
	private DnDCombatService cService;

	@MockBean
	private CombatRepo cRepo;

	@Test
	void testCreateCombat() {
		// GIVEN A NEW COMBATANT IS ADDDED WITH ID 1
		int ID = 1;
		Combat newCombatant = new Combat(13, "Jordan the Weapon", 4, 6, 9, true);
		Combat savedCombatant = new Combat(13, "Jordan the Weapon", 4, 6, 9, true);
		savedCombatant.setId(ID);

		// WHEN THE ADD COMBAT FUNCTION IS CALLED
		Mockito.when(this.cRepo.save(newCombatant)).thenReturn(savedCombatant);

		// THEN CHECK THE NEW COMBAT IS CORRECT
		assertThat(this.cService.createCombat(newCombatant)).isEqualTo(savedCombatant);

		Mockito.verify(this.cRepo, Mockito.times(1)).save(newCombatant);
	}

	@Test
	void testGetAllCombat() {
		// GIVEN TWO COMBATANTS ARE ADDED WItH ID'S 1 & 2
		int id = 1;
		Combat newCombatant1 = new Combat(13, "Jordan the Weapon", 4, 6, 9, true);
		newCombatant1.setId(id++);
		Combat newCombatant2 = new Combat(12, "Alan the Davies", 7, 4, 20, true);
		newCombatant2.setId(id);

		List<Combat> combatantList = new ArrayList<>();
		combatantList.add(newCombatant1);
		combatantList.add(newCombatant2);

		// WHEN THE GET ALL COMBAt IS CALLED
		Mockito.when(this.cRepo.findAll()).thenReturn(combatantList);

		// THEN CHECK THE LIST IS CORRECT
		assertThat(this.cService.getAllCombat()).isEqualTo(combatantList);

		Mockito.verify(this.cRepo, Mockito.times(1)).findAll();
	}

	@Test
	void testSuccssfulDeleteCombat() {
		int ID = 1;
		boolean idFound = true;

		Mockito.when(this.cRepo.existsById(ID)).thenReturn(idFound);

		assertThat(this.cService.deleteCombat(ID)).isEqualTo(!idFound);

		Mockito.verify(this.cRepo, Mockito.times(2)).existsById(ID);
	}

	@Test
	void testunsuccssfulDeleteCombat() {
		int ID = 1;
		boolean idFound = false;

		Mockito.when(this.cRepo.existsById(ID)).thenReturn(idFound);

		assertThat(this.cService.deleteCombat(ID)).isEqualTo(idFound);

		Mockito.verify(this.cRepo, Mockito.times(1)).existsById(ID);
	}

	@Test
	void testPatchCombatAC() {
		int ID = 1;
		int MOD = 1;
		Combat oldCombatant = new Combat(13, "Jordan the Weapon", 4, 6, 9, true);
		oldCombatant.setId(ID);
		Combat updatedCombatant = new Combat(13, "Jordan the Weapon", 5, 6, 9, true);
		updatedCombatant.setId(ID);

		Mockito.when(this.cRepo.findById(ID)).thenReturn(Optional.of(oldCombatant));
		Mockito.when(this.cRepo.save(oldCombatant)).thenReturn(updatedCombatant);

		assertThat(this.cService.patchCombatAC(ID, MOD)).isEqualTo(updatedCombatant);

		Mockito.verify(this.cRepo, Mockito.times(1)).findById(ID);
		Mockito.verify(this.cRepo, Mockito.times(1)).save(oldCombatant);
	}

	@Test
	void testPatchCombatHP() {
		int ID = 1;
		int MOD = -1;
		Combat oldCombatant = new Combat(13, "Jordan the Weapon", 4, 6, 9, true);
		oldCombatant.setId(ID);
		Combat updatedCombatant = new Combat(13, "Jordan the Weapon", 4, 5, 9, true);
		updatedCombatant.setId(ID);

		Mockito.when(this.cRepo.findById(ID)).thenReturn(Optional.of(oldCombatant));
		Mockito.when(this.cRepo.save(oldCombatant)).thenReturn(updatedCombatant);

		assertThat(this.cService.patchCombatHP(ID, MOD)).isEqualTo(updatedCombatant);

		Mockito.verify(this.cRepo, Mockito.times(1)).findById(ID);
		Mockito.verify(this.cRepo, Mockito.times(1)).save(oldCombatant);
	}

}
