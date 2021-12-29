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
    private PoliticalOfficeEnum politicalOfficeEnum;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne
    private PoliticalParties politicalParties;
}
