package com.qa.dnd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.dnd.persistance.domain.Combat;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class DnDBackendApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void giveCoveragePlz() {
		EqualsVerifier.forClass(Combat.class).usingGetClass().verify();
	}
}
