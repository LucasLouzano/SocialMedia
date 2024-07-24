package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.api.PaymentClientApi;
import ProjetoSocialMedia.SocialMedia.model.PaymentClient;
import ProjetoSocialMedia.SocialMedia.repository.PaymentClientRepository;
import ProjetoSocialMedia.SocialMedia.service.PaymentClientService;
import ProjetoSocialMedia.SocialMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentClientServiceImpl implements PaymentClientService {
    @Autowired
    private PaymentClientRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private PaymentClientApi  paymentClientApi;

    @Override
    public PaymentClient save() {
        PaymentClient paymentClient = new PaymentClient();
        paymentClient.setValor(paymentClientApi.getPaymentValueBy("S").valor());
        paymentClient.setUsuario(userService.getUsuario());
        paymentClient.setMes(LocalDateTime.now());
        return repository.save(paymentClient);
    }

    @Override
    public List<PaymentClient> findAll() {
        return repository.findAll();
    }

    @Override
    public List<PaymentClient> findBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findBetweenDates(startDate, endDate);
    }

    // Outros métodos do serviço
    @Override
    public Boolean paid() {
        return repository.findAll()
                .stream()
                .anyMatch(paymentClient ->
                        paymentClient.getValor() > 0);
    }

}
