package bookGenerator.policy;

import javax.transaction.Transactional;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import bookGenerator._global.config.kafka.KafkaProcessor;
import bookGenerator._global.logger.CustomLogger;
import bookGenerator._global.logger.CustomLoggerType;
import bookGenerator._global.event.ExistingCoverImageDeletingRequested;

@Service
@Transactional
public class ExistingCoverImageDeletingRequested_deleteExistingCoverImage_Policy {

    // ExistingCoverImageDeletingRequested 이벤트 발생 관련 정책
    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ExistingCoverImageDeletingRequested'"
    )
    public void existingCoverImageDeletingRequested_deleteExistingCoverImage_Policy(
        @Payload ExistingCoverImageDeletingRequested existingCoverImageDeletingRequested
    ) {
        try
        {
            
            CustomLogger.debugObject(CustomLoggerType.ENTER_EXIT, "ExistingCoverImageDeletingRequested", existingCoverImageDeletingRequested);

        } catch(Exception e) {
            CustomLogger.errorObject(e, "", existingCoverImageDeletingRequested);        
        }
    }

}
