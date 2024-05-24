package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.enums.StatusEmail;
import ProjetoSocialMedia.SocialMedia.mapper.EmailMapper;
import ProjetoSocialMedia.SocialMedia.model.email.EmailModel;
import ProjetoSocialMedia.SocialMedia.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailMapper mapper;

    @Transactional
    public EmailDto sendEmail(EmailModel email) {
        email.setSendDateEmail(LocalDateTime.now());
        EmailModel emailModel = repository.save(email);
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e) {

            email.setStatusEmail(StatusEmail.ERROR);

        } finally {

            return mapper.emailModelToEmailDto(emailModel);

        }
    }
}
