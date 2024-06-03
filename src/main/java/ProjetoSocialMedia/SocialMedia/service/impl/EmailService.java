package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.enums.StatusEmail;
import ProjetoSocialMedia.SocialMedia.mapper.EmailMapper;
import ProjetoSocialMedia.SocialMedia.model.EmailModel;
import ProjetoSocialMedia.SocialMedia.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private EmailRepository repository;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private EmailMapper mapper;

    @Transactional
    public EmailDto sendEmail(EmailModel email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            logger.error("Error sending email: ", e);
            email.setStatusEmail(StatusEmail.ERROR);
        }
        EmailModel emailModel = repository.save(email);
        return mapper.emailModelToEmailDto(emailModel);
    }

    public Page<EmailModel> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
