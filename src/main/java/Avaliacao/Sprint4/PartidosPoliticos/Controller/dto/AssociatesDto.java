package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOfficeEnum;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalParties;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;


@Data
public class AssociatesDto {

    private Long id;
    private String name;
    private PoliticalOfficeEnum politicalOfficeEnum;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;
    private Enum gender;
    private PoliticalParties politicalParties;

}
