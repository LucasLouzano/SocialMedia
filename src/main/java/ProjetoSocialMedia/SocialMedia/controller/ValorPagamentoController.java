package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.ValorPagamentoDTO;
import ProjetoSocialMedia.SocialMedia.dto.ValuePaymentDTO;
import ProjetoSocialMedia.SocialMedia.mapper.ValorPagamentoMapper;
import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;
import ProjetoSocialMedia.SocialMedia.service.impl.ValorPagamentoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class ValorPagamentoController {
    @Autowired
    private ValorPagamentoServiceImpl service;
    @Autowired
    private ValorPagamentoMapper Mapper;

    @GetMapping("/{snValorAtual}")
    public ResponseEntity<ValorPagamento> getPaymentValueBy(@PathVariable String snValorAtual) {
        ValorPagamento valorPagamento = service.findBySnValorAtual(snValorAtual);
        if (valorPagamento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(valorPagamento);
    }
    @PostMapping
    public ResponseEntity<ValuePaymentDTO> savePaymentValue(@RequestBody @Valid ValorPagamento dto) {
        ValorPagamentoDTO valorPagamentoDTO = service.save(dto);
        ValuePaymentDTO valuePaymentDTO = Mapper.mapValorPagToDto(valorPagamentoDTO);
        if (valuePaymentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(valuePaymentDTO);
    }
    @GetMapping("/paymentValues")
    public ResponseEntity <List<ValorPagamento>> getPaymentValue(){
        List<ValorPagamento> valorPagamentoList = service.findAll();
        if (valorPagamentoList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(valorPagamentoList);

    }
}


