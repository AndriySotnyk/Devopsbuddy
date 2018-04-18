package studio.crayfish.devopsbuddy.backend.service;

import org.springframework.mail.SimpleMailMessage;
import studio.crayfish.devopsbuddy.web.domain.frontend.FeedbackPojo;

public interface EmailService {
    public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

    public void sendGenericEmailMessage(SimpleMailMessage message);
}
