package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import Avaliacao.Sprint4.PartidosPoliticos.Entity.Ideology;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PoliticalPartiesFormDto {

    @NotBlank
    private String partiesName;

    @NotBlank
    private String initials;

    @NotNull
    private Ideology ideology;

    @NotNull
    private LocalDate foundationDate;
}
