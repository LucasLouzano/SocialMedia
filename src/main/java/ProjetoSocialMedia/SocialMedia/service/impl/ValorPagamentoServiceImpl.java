package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.mapper.ValorPagamentoMapper;
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
    @Autowired
    private ValorPagamentoMapper mapper;

    @Override
    public ValorPagamento findBySnValorAtual(String snValorAtual) {
        return repository.findBySnValorAtual(snValorAtual).orElse(null);
    }


    @Transactional
    @Override
    public ValorPagamentoDTO save(ValorPagamento valorPagamento) {
        ValorPagamento valorPgm = this.findBySnValorAtual("S");
        if (valorPgm != null) {
            valorPgm.setSnValorAtual("N");
            repository.save(valorPgm);
            return mapper.PagValueToPagValueDTO(valorPgm);
        }
        ValorPagamento novoValorPagamento = new ValorPagamento();
        novoValorPagamento.setValor(valorPagamento.getValor());
        novoValorPagamento.setData(LocalDateTime.now());
        novoValorPagamento.setSnValorAtual("S");
        repository.save(novoValorPagamento);
        return mapper.PagValueToPagValueDTO(novoValorPagamento);
    }

    @Override
    public List<ValorPagamento> findAll() {
        return repository.findAll();
    }
}
