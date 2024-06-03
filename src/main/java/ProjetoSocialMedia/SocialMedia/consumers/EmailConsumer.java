package ProjetoSocialMedia.SocialMedia.consumers;

import ProjetoSocialMedia.SocialMedia.dto.EmailDTOInfo;
import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.mapper.EmailMapper;
import ProjetoSocialMedia.SocialMedia.model.EmailModel;
import ProjetoSocialMedia.SocialMedia.service.impl.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailMapper emailMapper;


    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen(@Payload EmailDTOInfo emailDTOInfo) {
        EmailModel emailModel = emailMapper.mapDtoToEmail(emailDTOInfo);
        emailService.sendEmail(emailModel);
        System.out.println("Email Status: " + emailModel.getStatusEmail().toString());
    }
}