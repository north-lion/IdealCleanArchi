package ddd.domain.service;

import ddd.domain.dto.MessageDto;
import ddd.domain.model.HelloMessage;
import ddd.simple.proto.HelloRequest;

public class CreateMessageService {
    MessageDto messageDto;

    /**
     * Constructor
     */
    public CreateMessageService() {
        this.messageDto = new MessageDto();
    }
    public HelloMessage create(HelloRequest request) {
        return messageDto.convertToMessage(request);
    }
}
