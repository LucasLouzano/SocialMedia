package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;

import java.util.List;
import java.util.Optional;

public interface ValorPagamentoService {
    ValorPagamento findBySnValorAtual(String snValorAtual);
    ValorPagamento save(ValorPagamentoDTO dto);
    List<ValorPagamento> findAll();


}
