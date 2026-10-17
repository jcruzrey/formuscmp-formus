package com.formuscmp.formus.field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.button.Button;

/** What a button does after its command: kept through JSON when there is something, absent from existing files when there is not. */
class ButtonActionsSerializationTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	void theActionsOfAButtonSurviveJson() throws Exception {
		Button b = new Button();
		b.setName("guardar");
		b.setActions(List.of(Map.of("type", "adapter", "uuid", "ad-1", "variables", Map.of("a", "b"))));
		String json = mapper.writeValueAsString(b);
		assertTrue(json.contains("\"actions\""));
		assertEquals("ad-1", mapper.readValue(json, Button.class).getActions().get(0).get("uuid"));
	}

	@Test
	void withoutActionsNothingIsWritten() throws Exception {
		Button b = new Button();
		assertFalse(mapper.writeValueAsString(b).contains("actions"));
		b.setActions(List.of());
		assertFalse(mapper.writeValueAsString(b).contains("actions"));
	}
}
