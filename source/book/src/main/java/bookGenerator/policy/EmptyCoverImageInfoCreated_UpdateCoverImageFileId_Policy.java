package bookGenerator.policy;

import javax.transaction.Transactional;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import bookGenerator._global.config.kafka.KafkaProcessor;
import bookGenerator._global.logger.CustomLogger;
import bookGenerator._global.logger.CustomLoggerType;
import bookGenerator._global.event.EmptyCoverImageInfoCreated;

@Service
@Transactional
public class EmptyCoverImageInfoCreated_UpdateCoverImageFileId_Policy {

    // EmptyCoverImageInfoCreated 이벤트 발생 관련 정책
    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='EmptyCoverImageInfoCreated'"
    )
    public void emptyCoverImageInfoCreated_UpdateCoverImageFileId_Policy(
        @Payload EmptyCoverImageInfoCreated emptyCoverImageInfoCreated
    ) {
        try
        {
            
            CustomLogger.debugObject(CustomLoggerType.ENTER_EXIT, "EmptyCoverImageInfoCreated", emptyCoverImageInfoCreated);

        } catch(Exception e) {
            CustomLogger.errorObject(e, "", emptyCoverImageInfoCreated);        
        }
    }

}