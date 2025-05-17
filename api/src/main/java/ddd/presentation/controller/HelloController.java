package ddd.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ddd.application.HelloScenario;
import ddd.domain.exceptions.ServiceException;
import ddd.domain.model.HelloMessage;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.grpc.sample.proto.HelloReply;
import org.springframework.grpc.sample.proto.HelloRequest;
import org.springframework.grpc.sample.proto.SimpleGrpc;

@GrpcService
@Log4j2
public class HelloController extends SimpleGrpc.SimpleImplBase {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private HelloScenario scenario;

    /**
     * Constructor
     */
    public HelloController() {
        this.scenario = new HelloScenario();
    }

    /**
     * Execute Application HelloScenario.
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        try {
            // If DataType of inputData is String, Convert to ValueObject for execute application scenario.
            HelloMessage message = scenario.execute(request);

            HelloReply reply = HelloReply.newBuilder()
                    .setMessage("Send Message Completed! Message detail:" + MAPPER.writeValueAsString(message))
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (ServiceException e) {
            e.printStackTrace();
            if (e.isRetry()) log.info("This Error is Retryable!");
            responseObserver.onError(e);
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }
}
