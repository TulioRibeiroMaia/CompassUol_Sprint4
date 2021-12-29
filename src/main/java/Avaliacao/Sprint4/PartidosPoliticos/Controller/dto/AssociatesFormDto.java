package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Associates;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOfficeEnum;
import Avaliacao.Sprint4.PartidosPoliticos.repository.AssociatesRepository;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class AssociatesFormDto {

    @NotBlank
    private String name;

    @NotNull
    private PoliticalOfficeEnum politicalOfficeEnum;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Enum gender;

}
