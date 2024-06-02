package ProjetoSocialMedia.SocialMedia.service;
import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;
import java.util.List;

public interface ValorPagamentoService {
    ValorPagamento findBySnValorAtual(String snValorAtual);
    ValorPagamentoDTO save(ValorPagamento dto);
    List<ValorPagamento> findAll();


}
