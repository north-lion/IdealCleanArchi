package ddd.domain.service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import ddd.domain.exceptions.ServiceException;
import lombok.extern.log4j.Log4j2;
import org.springframework.grpc.sample.proto.HelloRequest;

@Log4j2
public class PrintMessageService {
    /**
     * Printing gRPC Message as Json Format.
     *
     * @param request
     * @throws ServiceException
     */
    public void print(final HelloRequest request) throws ServiceException {
        try {
            String messageStr = JsonFormat.printer().includingDefaultValueFields().print(request);
            log.info(messageStr);
        } catch (InvalidProtocolBufferException e) {
            throw new ServiceException(e.getMessage(), false);
        }
    }
}
