package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.PaymentClient;

import java.util.Date;
import java.util.List;

public interface PaymentClientService {

    PaymentClient save(PaymentClient paymentClient);
    List<PaymentClient> findAll();
    List<PaymentClient> findBetweenDates(Date startDate, Date endDate);
    Boolean paid();
}
