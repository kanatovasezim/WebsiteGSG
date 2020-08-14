package kg.itacademy.gsg.services.impls;

import kg.itacademy.gsg.entities.Mail;
import kg.itacademy.gsg.services.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailSenderServiceImpl implements MailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void sendForAll(Mail m) {
        List<String> userList = null;
        if(m.getActive() != null && m.getNonActive() != null && m.getActive() && m.getNonActive()){
            userList = userService.getEmailsByUserRole("ROLE_USER");
        }else if (m.getActive() != null && m.getActive()){
            userList = userService.getEmailsOfActiveClients();
        }else if (m.getNonActive() != null && m.getNonActive()){
            userList = userService.getEmailsOfNonActiveClients();
        }
        m.setTo(userList);
        if(m.getTo() != null){
            for (String s: m.getTo()) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("nurmanbetovbekbolot@gmail.com");
                message.setTo(s);
                message.setSubject(m.getSubject());
                message.setText(m.getMessage());
                mailSender.send(message);
            }
        }
    }

    @Override
    public void sendForAny(List<String> to, String subject, String text) {
        for (String s: to) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nurmanbetovbekbolot@gmail.com");
            message.setTo(s);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
        }
    }
}