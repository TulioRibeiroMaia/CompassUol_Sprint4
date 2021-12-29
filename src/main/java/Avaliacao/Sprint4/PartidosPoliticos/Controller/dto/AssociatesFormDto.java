package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Gender;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOffice;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AssociatesFormDto {

    @NotBlank
    private String name;

    @NotNull
    private PoliticalOffice politicalOffice;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Gender gender;

}
