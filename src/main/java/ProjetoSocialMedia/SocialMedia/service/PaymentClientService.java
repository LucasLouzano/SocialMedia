package ProjetoSocialMedia.SocialMedia.service;
import ProjetoSocialMedia.SocialMedia.model.PaymentClient;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentClientService {

    PaymentClient save(PaymentClient paymentClient);
    List<PaymentClient> findAll();
    List<PaymentClient> findBetweenDates(LocalDateTime startDateTime, LocalDateTime endDateTime);
    Boolean paid();

}
