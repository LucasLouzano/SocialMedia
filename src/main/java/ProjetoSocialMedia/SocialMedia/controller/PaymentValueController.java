package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.api.PaymentClientApi;
import ProjetoSocialMedia.SocialMedia.paymentdto.PaymentValue;

import ProjetoSocialMedia.SocialMedia.paymentdto.PaymentValueDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/socialmedia")
public class PaymentValueController {
    @Autowired
    private PaymentClientApi paymentClientApi;


    @GetMapping("/{snCurrentValue}")
    public ResponseEntity<PaymentValue> getPaymentValueBy(@PathVariable String snCurrentValue) {
        PaymentValue valorPagamento = paymentClientApi.getPaymentValueBy(snCurrentValue);
        if (valorPagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valorPagamento);
    }
    @PostMapping
    public ResponseEntity<PaymentValueDTO> savePaymentValue(@RequestBody @Valid PaymentValue dto) {
        PaymentValueDTO PaymentDTO = paymentClientApi.savePaymentValue(dto);
        if (PaymentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(PaymentDTO);
    }
    @GetMapping("/paymentValues")
    public ResponseEntity <List<PaymentValue>> getPaymentValue(){
        List<PaymentValue> paymentValuesList = paymentClientApi.getPaymentValue();
        if (paymentValuesList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(paymentValuesList);

    }
}
