package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.api.PaymentClientApi;
import ProjetoSocialMedia.SocialMedia.dto.PaymentValue;

import ProjetoSocialMedia.SocialMedia.dto.PaymentValueDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pagamento")
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

}
