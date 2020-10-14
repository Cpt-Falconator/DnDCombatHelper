package com.qa.dnd.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

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

	}

	@Test
	void testGetAllCombat() {

	}

	@Test
	void testDeleteCombat() {
	}

	@Test
	void testPatchCombatAC() {
	}

	@Test
	void testPatchCombatHP() {

	}
}
