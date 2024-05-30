package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.ValorPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValorPagamentoRepository extends JpaRepository<ValorPagamento, Long> {

    Optional<ValorPagamento> findBySnValorAtual(String snValorAtual);
}
