package ddd.infrastructure;

import ddd.domain.repository.SendHelloRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SendHelloRepositoryImpl implements SendHelloRepository {
    public void send(String requestBody) {
        log.info("RequestBody:" + requestBody);
    }
}
