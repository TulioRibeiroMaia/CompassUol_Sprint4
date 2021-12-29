package Avaliacao.Sprint4.PartidosPoliticos.Controller.dto;


import Avaliacao.Sprint4.PartidosPoliticos.Entity.Ideology;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticalPartiesDto {

    private Long id;

    private String partiesName;

    private String initials;

    private Ideology ideology;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate foundationDate;
}
