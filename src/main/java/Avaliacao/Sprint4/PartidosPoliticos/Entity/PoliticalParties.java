package Avaliacao.Sprint4.PartidosPoliticos.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PoliticalParties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partiesName;
    private String initials;
    @Enumerated(EnumType.STRING)
    private Ideology ideology;
    private LocalDate foundationDate;

}
