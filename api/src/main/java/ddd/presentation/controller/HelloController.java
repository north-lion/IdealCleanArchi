package ddd.presentation.controller;

import ddd.application.HelloScenario;
import ddd.domain.exceptions.DomainNoRetrievableException;
import ddd.domain.exceptions.DomainRetrievableException;
import ddd.domain.model.HelloMessage;
import ddd.simple.proto.GreeterGrpc;
import ddd.simple.proto.HelloReply;
import ddd.simple.proto.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Log4j2
public class HelloController extends GreeterGrpc.GreeterImplBase {
    private HelloScenario scenario;

    /**
     * Constructor
     */
    public HelloController() {
        this.scenario = new HelloScenario();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        try {
            // If DataType of inputData is String, Convert to ValueObject for execute application scenario.
            HelloMessage message = scenario.execute(request);
            // Reply Success Message.
            responseObserver.onNext(createSuccessMessage());
            responseObserver.onCompleted();
        } catch (DomainNoRetrievableException e) {
            // Reply No Retrievable Error Message.
            responseObserver.onNext(createErrorMessage());
            responseObserver.onCompleted();
        } catch (DomainRetrievableException e) {
            // Throw Exception.
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    /**
     * Create SuccessMessage.
     *
     * @return HelloReply
     */
    private HelloReply createSuccessMessage() {
        return HelloReply.newBuilder()
                .setMessage("Message Send Succeeded!")
                .build();
    }

    /**
     * Create ErrorMessage.
     *
     * @return HelloReply
     */
    private HelloReply createErrorMessage() {
        return HelloReply.newBuilder()
                .setMessage("Message Send Error. But, This error is no This error is not retrievable.")
                .build();
    }
}
