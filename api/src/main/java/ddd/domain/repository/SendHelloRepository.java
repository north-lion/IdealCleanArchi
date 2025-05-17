package ddd.domain.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import ddd.domain.model.HelloMessage;

public interface SendHelloRepository {
    void send(String requestBody);
}
