package Avaliacao.Sprint4.PartidosPoliticos.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class PoliticalParties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partiesName;
    private String initials;
    @Enumerated(EnumType.STRING)
    private Enum ideology;
    private LocalDate foundationDate;

}
