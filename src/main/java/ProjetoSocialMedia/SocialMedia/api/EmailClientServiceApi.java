package ProjetoSocialMedia.SocialMedia.api;

import ProjetoSocialMedia.SocialMedia.dto.EmailDTO;
import ProjetoSocialMedia.SocialMedia.dto.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class EmailClientServiceApi {

    @Autowired
    private RestTemplate restTemplate;

    public EmailModel sendEmail(EmailDTO emailDTO) {
        String url = "http://localhost:8084/sending-email";
        HttpEntity<EmailDTO> request = new HttpEntity<>(emailDTO);
        ResponseEntity<EmailModel> response = restTemplate.exchange(url, HttpMethod.POST, request, EmailModel.class);
        return response.getBody();
    }
    public Page<EmailModel> getAllEmails(Pageable pageable) {
        String url = String.format("http://localhost:8084/emails?page=%d&size=%d&sort=%s,%s",
                pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().iterator().next().getProperty(), pageable.getSort().iterator().next().getDirection());
        ResponseEntity<Page<EmailModel>> response = restTemplate.exchange(url, HttpMethod.GET, null, (Class<Page<EmailModel>>) (Class<?>) Page.class);
        return response.getBody();
    }

    public EmailModel getEmailById(UUID emailId) {
        String url = "http://localhost:8084/emails/" + emailId.toString();
        return restTemplate.getForObject(url, EmailModel.class);
    }
}