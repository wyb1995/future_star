package com.thoughtworks.futurestar.repository;

import java.util.Map;

public interface TokenAuthRepository {
    String generateToken(Map<String, Object> payload);
    String extractAuthorizedPayload(String token);
}
