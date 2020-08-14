package kg.itacademy.gsg.services;

import kg.itacademy.gsg.entities.Mail;

import java.util.List;

public interface MailSenderService {
    void sendForAll(Mail m);
    void sendForAny(List<String> to, String subject, String message);
}
