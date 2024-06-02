package ProjetoSocialMedia.SocialMedia.mapper;
import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.dto.ValuePaymentDTO;
import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ValorPagamentoMapper {
    ValorPagamentoMapper INSTANCE = Mappers.getMapper(ValorPagamentoMapper.class);

    ValorPagamentoDTO PagValueToPagValueDTO(ValorPagamento valorPagamento);
    ValuePaymentDTO mapValorPagToDto(ValorPagamentoDTO valorPagamentoDTO);
}
