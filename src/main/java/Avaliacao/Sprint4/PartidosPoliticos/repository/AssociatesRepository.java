package Avaliacao.Sprint4.PartidosPoliticos.repository;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Associates;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOfficeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociatesRepository extends JpaRepository<Associates, Long > {

    Optional<Associates> findById(Long id);

    List<Associates> findByPoliticalOffice(PoliticalOfficeEnum politicalOffice);
}
