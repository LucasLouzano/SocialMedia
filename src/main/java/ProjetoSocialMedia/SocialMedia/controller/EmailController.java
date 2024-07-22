package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.api.EmailClientServiceApi;
import ProjetoSocialMedia.SocialMedia.dto.EmailDTO;
import ProjetoSocialMedia.SocialMedia.dto.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/socialmedia")
public class EmailController {
    @Autowired
    private EmailClientServiceApi emailApi;

    @PostMapping("/emails")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody EmailDTO emailDTO) {
        EmailModel emailModel = emailApi.sendEmail(emailDTO);
        return ResponseEntity.status(201).body(emailModel);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<EmailModel>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<EmailModel> emailPage = emailApi.getAllEmails(pageable);
        return ResponseEntity.ok(emailPage);
    }

    @GetMapping("/emails/{emailId}")
    public ResponseEntity<EmailModel> getEmailById(@PathVariable UUID emailId) {
        EmailModel emailModel = emailApi.getEmailById(emailId);
        if (emailModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(emailModel);
    }
}