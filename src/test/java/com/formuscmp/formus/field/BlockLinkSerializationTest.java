package com.formuscmp.formus.field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formuscmp.formus.button.Button;

/** The link of a field or a button to the shared block it was copied from: kept when set, absent from the stored JSON when not (existing files do not change). */
class BlockLinkSerializationTest {

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	void aFieldCarriesItsBlockUuidThroughJson() throws Exception {
		Field f = new Field();
		f.setName("rfc");
		f.setBlockUuid("blk-1");
		String json = mapper.writeValueAsString(f);
		assertTrue(json.contains("\"blockUuid\":\"blk-1\""));
		assertEquals("blk-1", mapper.readValue(json, Field.class).getBlockUuid());
	}

	@Test
	void withoutALinkThePropertyIsNotWritten() throws Exception {
		assertFalse(mapper.writeValueAsString(new Field()).contains("blockUuid"));
		assertFalse(mapper.writeValueAsString(new Button()).contains("blockUuid"));
	}

	@Test
	void aButtonCarriesItsBlockUuidThroughJson() throws Exception {
		Button b = new Button();
		b.setBlockUuid("blk-2");
		assertEquals("blk-2", mapper.readValue(mapper.writeValueAsString(b), Button.class).getBlockUuid());
	}
}
