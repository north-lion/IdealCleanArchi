package ddd.application;

import ddd.domain.exceptions.DomainNoRetrievableException;
import ddd.domain.exceptions.DomainRetrievableException;
import ddd.domain.model.HelloMessage;
import ddd.domain.service.CreateMessageService;
import ddd.domain.service.PrintMessageService;
import ddd.domain.service.SendMessageService;
import ddd.simple.proto.HelloRequest;

public class HelloScenario {
    // Define Service Classes
    PrintMessageService printService;
    CreateMessageService createService;
    SendMessageService sendService;

    /**
     * Constructor
     */
    public HelloScenario() {
        this.printService = new PrintMessageService();
        this.createService = new CreateMessageService();
        this.sendService = new SendMessageService();
    }
    public HelloMessage execute(final HelloRequest request) throws DomainNoRetrievableException, DomainRetrievableException {
        // Print HelloRequest Detail.
        printService.print(request);
        // Create Message.
        HelloMessage message = createService.create(request);
        // Send Message.
        sendService.send(message);

        return message;
    }
}
