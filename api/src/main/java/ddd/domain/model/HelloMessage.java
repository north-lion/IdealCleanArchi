package ddd.domain.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class HelloMessage {

    /**
     * Constructor
     */
    public HelloMessage(String name) {
       this.messageId = UUID.randomUUID().toString();
       this.messageBody = "Hello," + name;
    }

    String messageId;

    String messageBody;
}
