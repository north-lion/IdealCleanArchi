package ddd.domain.dto;

import ddd.domain.model.HelloMessage;
import org.springframework.grpc.sample.proto.HelloRequest;

public class MessageDto {
    public HelloMessage convertToMessage(HelloRequest request) {
        return new HelloMessage(request.getName());
    }
}
