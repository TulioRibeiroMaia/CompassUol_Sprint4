package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PoliticalPartiesFormDto {

    @NotBlank
    private String partiesName;

    @NotBlank
    private String initials;

    @NotNull
    private Enum ideology;

    @NotNull
    private LocalDate foundationDate;
}
