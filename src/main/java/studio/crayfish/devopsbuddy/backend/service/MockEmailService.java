package studio.crayfish.devopsbuddy.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {
    /** The application Logger*/
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    public void sendGenericEmailMessage(SimpleMailMessage message){
        System.out.println("Simulating email service ...");
        System.out.println(message.toString());
        System.out.println("message sent");
    }
}
