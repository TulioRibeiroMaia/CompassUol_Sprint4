package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Gender;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOffice;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalParties;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociatesDto {

    private Long id;

    private String name;

    private PoliticalOffice politicalOffice;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private Gender gender;

    private PoliticalParties politicalParties;
}
