package Avaliacao.Sprint4.PartidosPoliticos.repository;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Ideology;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalParties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PoliticalPartiesRepository extends JpaRepository<PoliticalParties, Long > {

    List<PoliticalParties> findByIdeology(Ideology ideology);

    Optional<PoliticalParties> findById(Long id);

}
