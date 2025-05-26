package ddd.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ddd.domain.exceptions.DomainRetrievableException;
import ddd.domain.model.HelloMessage;
import ddd.domain.repository.SendHelloRepository;
import ddd.infrastructure.SendHelloRepositoryImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SendMessageService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    SendHelloRepository sendRepository;

    /**
     * Constructor
     */
    public SendMessageService() {
        this.sendRepository = new SendHelloRepositoryImpl();
    }

    public void send(HelloMessage message) throws DomainRetrievableException {
        try {
            String requestBody = MAPPER.writeValueAsString(message);
            sendRepository.send(requestBody);
        } catch (JsonProcessingException e) {
            throw new DomainRetrievableException(e.getMessage());
        }
    }
}
