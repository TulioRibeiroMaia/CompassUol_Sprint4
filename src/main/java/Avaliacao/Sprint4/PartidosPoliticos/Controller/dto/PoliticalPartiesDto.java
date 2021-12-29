package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDate;

public class PoliticalPartiesDto {

    private Long id;

    private String partiesName;

    private String initials;

    private Enum ideology;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate foundationDate;
}
