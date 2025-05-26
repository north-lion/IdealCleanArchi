package ddd.domain.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ddd.domain.exceptions.DomainNoRetrievableException;
import ddd.simple.proto.HelloRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PrintMessageService {
    /**
     * Printing gRPC Message as Json Format.
     *
     * @param request
     * @throws DomainNoRetrievableException
     */
    public void print(final HelloRequest request) throws DomainNoRetrievableException {
        try {
            String messageStr = JsonFormat.printer().includingDefaultValueFields().print(request);
            log.info(messageStr);
        } catch (InvalidProtocolBufferException e) {
            throw new DomainNoRetrievableException(e.getMessage());
        }
    }
}
