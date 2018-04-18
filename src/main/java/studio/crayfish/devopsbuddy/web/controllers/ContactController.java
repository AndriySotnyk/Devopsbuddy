package studio.crayfish.devopsbuddy.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import studio.crayfish.devopsbuddy.backend.service.EmailService;
import studio.crayfish.devopsbuddy.web.domain.frontend.FeedbackPojo;

@Controller
public class ContactController {
    /** The application Logger*/
    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
    
    /**The key which identifies the feedback payload int the Model.*/
    public static final String FEEDBACK_MODEL_KEY="feedback";

    /**The Contact US view name. */
    private static final String CONTACT_US_VIEW_NAME="contact/contact";

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactGet(Model model){
        FeedbackPojo feedbackPojo=new FeedbackPojo();
        model.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
        return ContactController.CONTACT_US_VIEW_NAME;
    }
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedback){
        LOG.info("Feedback POJO content {}", feedback);
        emailService.sendFeedbackEmail(feedback);
        return "index";
    }
}
