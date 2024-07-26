package ProjetoSocialMedia.SocialMedia.api;

import ProjetoSocialMedia.SocialMedia.paymentdto.PaymentValue;

import ProjetoSocialMedia.SocialMedia.paymentdto.PaymentValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class PaymentClientApi {

    @Autowired
    private RestTemplate restTemplate;

    public PaymentValue getPaymentValueBy(String snCurrentValue) {
        String url = "http://localhost:8083/pagamento/" + snCurrentValue;
        ResponseEntity<PaymentValue> response = restTemplate.getForEntity(url, PaymentValue.class);
        return response.getBody();
    }
    public PaymentValueDTO savePaymentValue(PaymentValue paymentValue) {
        String url = "http://localhost:8083/pagamento";
        ResponseEntity<PaymentValueDTO> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(paymentValue), PaymentValueDTO.class);
        return response.getBody();
    }
    public List<PaymentValue> getPaymentValue() {
        String url = "http://localhost:8083/pagamento/paymentValues";
        ResponseEntity<PaymentValue> response = restTemplate.getForEntity(url, PaymentValue.class);
        PaymentValue paymentValuesArray = response.getBody();
        return Arrays.asList(paymentValuesArray);
    }
}