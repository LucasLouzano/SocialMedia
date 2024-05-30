package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.EmailDTOInfo;
import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.mapper.EmailMapper;
import ProjetoSocialMedia.SocialMedia.model.EmailModel;
import ProjetoSocialMedia.SocialMedia.service.impl.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    }


