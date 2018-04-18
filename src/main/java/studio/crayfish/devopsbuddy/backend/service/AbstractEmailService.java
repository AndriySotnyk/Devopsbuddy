package studio.crayfish.devopsbuddy.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import studio.crayfish.devopsbuddy.web.domain.frontend.FeedbackPojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class AbstractEmailService implements EmailService{

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Value("${default.to.address}")
    private String defaultToAddress;

    protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(defaultToAddress);
        message.setFrom(feedback.getEmail());
        message.setSentDate(date);
        message.setSubject("Feedback from" + feedback.getFirstName()+
                ' ' + feedback.getLastName() +'!');
        message.setText(feedback.getFeedback());
        return message;
    }

    public void sendFeedbackEmail(FeedbackPojo feedback){
        sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedback));
    }
}
