package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.PaymentRequestBetwennDate;
import ProjetoSocialMedia.SocialMedia.model.PaymentClient;
import ProjetoSocialMedia.SocialMedia.service.PaymentClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/paymentClients")
public class PaymentClientController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentClientController.class);
    @Autowired
    private PaymentClientService service;

    @GetMapping("/betweenDates")
    public ResponseEntity<List<PaymentClient>> findPaymentClientsBetweenDates(@RequestBody PaymentRequestBetwennDate request) {
        LocalDateTime startDateTime = request.startDate().atStartOfDay();
        LocalDateTime endDateTime = request.endDate().atTime(LocalTime.MAX);

        List<PaymentClient> paymentClients = service.findBetweenDates(startDateTime, endDateTime);

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