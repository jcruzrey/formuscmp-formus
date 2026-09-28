package com.formuscmp.formus.resource;

import java.time.Instant;
import java.util.UUID;
import java.util.function.Supplier;

public class GenerateCode {

	public String generarToken() {
		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		return tokenSupplier.get();
	}
	
}
