package ProjetoSocialMedia.SocialMedia.service.impl;

import org.junit.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class EmailServiceTest {
//    @InjectMocks
//    private EmailService emailService;
//    @Mock
//    private EmailRepository repository;
//    @Mock
//    private JavaMailSender emailSender;
//    private EmailMapper mapper;
//
//    @Test
//    public void testSendEmail() {
//        EmailModel emailModel = new EmailModel();
//        emailModel.setEmailFrom("test@example.com");
//        emailModel.setEmailTo("recipient@example.com");
//        emailModel.setSubject("Test Subject");
//        emailModel.setText("Test Text");
//
//
//        EmailDto emailDto = new EmailDto();
//        emailDto.setEmailFrom("test@example.com");
//        emailDto.setEmailTo("recipient@example.com");
//        emailDto.setSubject("Test Subject");
//        emailDto.setText("Test Text");
//
//        when(repository.save(any())).thenReturn(emailModel);
//        when(mapper.emailModelToEmailDto(any())).thenReturn(emailDto);
//
//        emailService.sendEmail(emailModel);
//
//
//        verify(emailSender, Mockito.times(1)).send(ArgumentMatchers.any(SimpleMailMessage.class));
//    }
//}