package comcodexmo.secondservice.listner;


import com.google.gson.Gson;
import comcodexmo.secondservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class UserListener {

    private final Logger logger = LoggerFactory.getLogger(UserListener.class);

    @Value("${topic.name.consumer")
    private String topicName;


    @KafkaListener(topics = "${topic.name.consumer}", groupId = "hcl_group")
    public void newUserConsume(String userString) {
        logger.info(String.format(" User -> %s", userString));
    }
}
