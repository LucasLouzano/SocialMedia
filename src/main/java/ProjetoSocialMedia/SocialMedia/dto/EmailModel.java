package ProjetoSocialMedia.SocialMedia.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmailModel (UUID emailId, String ownerRef, String emailFrom, String emailTo, String subject, String text, LocalDateTime sendDateEmail){

}

