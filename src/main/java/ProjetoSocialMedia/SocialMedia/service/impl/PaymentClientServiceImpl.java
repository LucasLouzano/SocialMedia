package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.PaymentClient;
import ProjetoSocialMedia.SocialMedia.repository.PaymentClientRepository;
import ProjetoSocialMedia.SocialMedia.service.PaymentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PaymentClientServiceImpl implements PaymentClientService {
    @Autowired
    private PaymentClientRepository repository;

    @Override
    public PaymentClient save(PaymentClient paymentClient) {
        paymentClient.setMes(LocalDateTime.now());
        return repository.save(paymentClient);
    }

    @Override
    public List<PaymentClient> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PaymentClient> findBetweenDates(Date startDate, Date endDate) {
        return repository.findBetweenDates(startDate, endDate);
    }

    @Override
    public Boolean paid() {
        return repository.findAll()
                .stream()
                .anyMatch(paymentClient ->
                        paymentClient.getValor() > 0);
    }
}
