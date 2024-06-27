package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.PaymentClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentClientRepository extends JpaRepository<PaymentClient,Long> {
    @Query("SELECT p FROM PaymentClient p WHERE p.mes BETWEEN :startDate AND :endDate")
    List<PaymentClient> findBetweenDates(Date startDate, Date endDate);

}
