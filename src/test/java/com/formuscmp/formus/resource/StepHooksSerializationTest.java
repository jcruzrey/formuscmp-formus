package com.formuscmp.formus.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

/** A workflow step keeps what it does when entered or left, and a step without any is written exactly as before. */
class StepHooksSerializationTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	void theActionsOfAStepSurviveJson() throws Exception {
		Step s = new Step();
		s.setName("captura");
		s.setOnLeave(List.of(Map.of("type", "template", "uuid", "tp-1", "to", "a@example.org")));
		String json = mapper.writeValueAsString(s);
		assertTrue(json.contains("\"onLeave\""));
		Step back = mapper.readValue(json, Step.class);
		assertEquals("tp-1", back.getOnLeave().get(0).get("uuid"));
	}

	@Test
	void withoutActionsNothingIsWrittenSoExistingFilesDoNotChange() throws Exception {
		Step s = new Step();
		s.setName("captura");
		s.setOnEnter(List.of());
		String json = mapper.writeValueAsString(s);
		assertFalse(json.contains("onEnter") || json.contains("onLeave"), json);
	}

	@Test
	void aWorkflowFileWithActionsLoadsIntoTheEngineClass() throws Exception {
		String json = "{\"name\":\"alta\",\"steps\":{\"uno\":{\"name\":\"uno\",\"order\":1,\"onEnter\":[{\"type\":\"adapter\",\"uuid\":\"ad-1\",\"variables\":{\"a\":\"b\"}}]}}}";
		UseCase u = mapper.readValue(json, UseCase.class);
		assertEquals("ad-1", u.getSteps().get("uno").getOnEnter().get(0).get("uuid"));
	}
}
