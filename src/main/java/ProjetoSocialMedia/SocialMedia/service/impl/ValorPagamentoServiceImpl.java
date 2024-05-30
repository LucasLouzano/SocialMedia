package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;
import ProjetoSocialMedia.SocialMedia.repository.ValorPagamentoRepository;
import ProjetoSocialMedia.SocialMedia.service.ValorPagamentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ValorPagamentoServiceImpl implements ValorPagamentoService {
    @Autowired
    private ValorPagamentoRepository repository;

    @Override
    public ValorPagamento findBySnValorAtual(String snValorAtual) {
       Optional <ValorPagamento> valorPagamento = repository.findBySnValorAtual(snValorAtual);
        return valorPagamento.orElse(null);
    }

    @Transactional
    @Override
    public ValorPagamento save(ValorPagamentoDTO dto) {
        ValorPagamento valorPagamento = this.findBySnValorAtual("S");
        if (valorPagamento != null){
            valorPagamento.setSnValorAtual("N");
            repository.save(valorPagamento);
        }
      ValorPagamento valorPagamento1 = new ValorPagamento();
        valorPagamento1.setValor(dto.valor());
        valorPagamento1.setData(LocalDateTime.now());
        valorPagamento1.setSnValorAtual("S");
        return repository.save(valorPagamento1);
    }

    @Override
    public List<ValorPagamento> findAll() {
        return repository.findAll();
    }
}
