package studio.crayfish.devopsbuddy.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.logging.Logger;

public class SmtpEmailService extends AbstractEmailService{
    /** The application Logger*/
    private static final Logger LOG = Logger.getLogger(SmtpEmailService.class.getName());

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendGenericEmailMessage(SimpleMailMessage message) {
        LOG.info("Sending email");
        mailSender.send(message);
        LOG.info("Email sent");

    }
}
