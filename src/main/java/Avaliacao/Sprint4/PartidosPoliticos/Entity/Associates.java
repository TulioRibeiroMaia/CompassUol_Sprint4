package Avaliacao.Sprint4.PartidosPoliticos.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Associates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PoliticalOffice politicalOffice;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private PoliticalParties politicalParties;
}
