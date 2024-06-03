package ProjetoSocialMedia.SocialMedia.mapper;

import ProjetoSocialMedia.SocialMedia.dto.EmailDTOInfo;
import ProjetoSocialMedia.SocialMedia.dto.EmailDto;
import ProjetoSocialMedia.SocialMedia.model.EmailModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
    EmailDto emailModelToEmailDto(EmailModel emailModel);
    EmailDTOInfo mapEmailToDto(EmailDto emailDto);
    EmailModel mapDtoToEmail(EmailDTOInfo emailDTOInfo);
}
