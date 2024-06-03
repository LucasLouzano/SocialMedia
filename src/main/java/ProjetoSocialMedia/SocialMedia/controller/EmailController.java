package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.EmailDTOInfo;
import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.mapper.EmailMapper;
import ProjetoSocialMedia.SocialMedia.model.EmailModel;
import ProjetoSocialMedia.SocialMedia.service.impl.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailMapper emailMapper;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailDTOInfo> sendingEmail(@RequestBody @Valid EmailModel emailModel) {
        EmailDto emailDto = emailService.sendEmail(emailModel);
        EmailDTOInfo emailDTOInfo = emailMapper.mapEmailToDto(emailDto);
        return new ResponseEntity<>(emailDTOInfo, HttpStatus.CREATED);
    }

    @GetMapping("/emails")
    public ResponseEntity<Page<EmailModel>> getAllEmails(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ResponseEntity<>(emailService.findAll(pageable), HttpStatus.OK);
    }
    @GetMapping("/emails/{emailId}")
    public ResponseEntity<Object> getOneEmail(@PathVariable(value="emailId") UUID emailId){
        Optional<EmailModel> emailModelOptional = emailService.findById(emailId);
        if(!emailModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found.");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(emailModelOptional.get());
        }
    }
}