package ProjetoSocialMedia.SocialMedia.paymentdto;


import java.time.LocalDateTime;

public record PaymentValue(Long id, double valor, LocalDateTime data, String snCurrenteValue)  {


}
