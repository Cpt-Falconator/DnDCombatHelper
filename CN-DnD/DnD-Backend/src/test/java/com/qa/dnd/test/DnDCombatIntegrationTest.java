package com.qa.dnd.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.dnd.persistance.domain.Combat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:combat-schema.sql",
		"classpath:combat-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class DnDCombatIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {

		Combat newCombatent = new Combat(13, "Jordan the Weapon", 5, 14, 15, true);
		String requestBody = this.mapper.writeValueAsString(newCombatent);
		RequestBuilder request = post("/create/combat").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Combat savedCombatent = new Combat(13, "Jordan the Weapon", 5, 14, 15, true);
		savedCombatent.setId(2);

		String resultBody = this.mapper.writeValueAsString(savedCombatent);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testSuccessfulDelete() throws Exception {

		int ID_TO_DELETE = 1;

		RequestBuilder request = delete("/delete/combat/" + ID_TO_DELETE);

		ResultMatcher checkStatus = status().isOk();

		this.mockMvc.perform(request).andExpect(checkStatus);

	}

	@Test
	void testUnsuccessfulDelete() throws Exception {

	}

	@Test
	void testUpdateAC() throws Exception {

		String ID_TO_EDIT = "1";
		String requestBodyAdd = this.mapper.writeValueAsString(1);
		RequestBuilder request = patch("/patch/combatAC/" + ID_TO_EDIT).contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAdd);

		ResultMatcher checkStatus = status().isAccepted();

		this.mockMvc.perform(request).andExpect(checkStatus);

		String requestBodyMinus = this.mapper.writeValueAsString(-1);
		request = patch("/patch/combatAC/" + ID_TO_EDIT).contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyMinus);

		this.mockMvc.perform(request).andExpect(checkStatus);
	}

	@Test
	void testUpdateHP() throws Exception {

		String ID_TO_EDIT = "1";
		String requestBodyAdd = this.mapper.writeValueAsString(1);
		RequestBuilder request = patch("/patch/combatHP/" + ID_TO_EDIT).contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAdd);

		ResultMatcher checkStatus = status().isAccepted();

		this.mockMvc.perform(request).andExpect(checkStatus);

		String requestBodyMinus = this.mapper.writeValueAsString(-1);
		request = patch("/patch/combatHP/" + ID_TO_EDIT).contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyMinus);

		this.mockMvc.perform(request).andExpect(checkStatus);
	}

	@Test
	void testGetCombat() throws Exception {
		Combat combatant = new Combat(7, "Alan the Davies", 10, 12, 15, true);
		combatant.setId(1);

		List<Combat> combatants = new ArrayList<>();
		combatants.add(combatant);
		String responseBody = this.mapper.writeValueAsString(combatants);

		RequestBuilder request = get("/get/allCombat").contentType(MediaType.APPLICATION_JSON).content(responseBody);

		ResultMatcher checkStatus = status().isOk();

		this.mockMvc.perform(request).andExpect(checkStatus);
		System.out.println(responseBody);
	}

}
