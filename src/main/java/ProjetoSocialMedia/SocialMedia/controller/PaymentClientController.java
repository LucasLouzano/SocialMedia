package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.PaymentClient;
import ProjetoSocialMedia.SocialMedia.service.PaymentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/paymentClients")
public class PaymentClientController {
    @Autowired
    private PaymentClientService service;

    @GetMapping("/betweenDates")
    public ResponseEntity<List<PaymentClient>> findPaymentClientsBetweenDates(@RequestBody Date startDate, Date endDate) {
        List<PaymentClient> paymentClients = service.findBetweenDates(startDate, endDate);
        if (paymentClients.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(paymentClients);
    }



    @GetMapping
    public ResponseEntity<List<PaymentClient>> findAllPaymentClients() {
        List<PaymentClient> paymentClientList = service.findAll();
        if (paymentClientList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paymentClientList);
    }

    @PostMapping
    public ResponseEntity<PaymentClient> savePaymentClient(@RequestBody PaymentClient paymentClient) {
        PaymentClient payment = service.save(paymentClient);
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/paid")
    public ResponseEntity<Boolean> checkIfPaid() {
        Boolean paidClient = service.paid();
        if (paidClient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paidClient);
    }
}
