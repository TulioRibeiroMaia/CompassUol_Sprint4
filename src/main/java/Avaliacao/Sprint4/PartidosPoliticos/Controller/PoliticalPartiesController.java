package Avaliacao.Sprint4.PartidosPoliticos.Controller;

import Avaliacao.Sprint4.PartidosPoliticos.Controller.dto.AssociatesDto;
import Avaliacao.Sprint4.PartidosPoliticos.Controller.dto.PoliticalPartiesDto;
import Avaliacao.Sprint4.PartidosPoliticos.Controller.dto.PoliticalPartiesFormDto;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.Ideology;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalParties;
import Avaliacao.Sprint4.PartidosPoliticos.repository.PoliticalPartiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partidos")
public class PoliticalPartiesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PoliticalPartiesRepository politicalPartiesRepository;

    //cadastrar partidos
    @PostMapping
    @Transactional
    public ResponseEntity<PoliticalPartiesDto> register(@RequestBody @Valid PoliticalPartiesFormDto form, UriComponentsBuilder uriBuilder) {
        PoliticalParties politicalParties = modelMapper.map(form, PoliticalParties.class);
        politicalPartiesRepository.save(politicalParties);

        URI uri = uriBuilder.path(("/partidos")).buildAndExpand(politicalParties.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(politicalParties, PoliticalPartiesDto.class));
    }


    //Lista os partidos com filtro por ideologia
    @GetMapping
    public List<PoliticalPartiesDto> listByFilter(@RequestParam(required = false) Ideology ideology) {
        if (ideology == null) {
            List<PoliticalParties> politicalParties = politicalPartiesRepository.findAll();
            return politicalParties.stream().map(parties -> modelMapper.map(parties, PoliticalPartiesDto.class)).collect(Collectors.toList());
        }else {
            List<PoliticalParties> politicalParties = politicalPartiesRepository.findByIdeology(ideology);
            return politicalParties.stream().map(parties -> modelMapper.map(parties, PoliticalPartiesDto.class)).collect(Collectors.toList());
        }
    }

    //Lista os partidos referenciado ao id
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<PoliticalPartiesDto> search(@PathVariable Long id) {
        Optional<PoliticalParties> politicalParties = politicalPartiesRepository.findById(id);
        return politicalParties.map(politicalPartie-> ResponseEntity.ok(modelMapper.map(politicalPartie, PoliticalPartiesDto.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //atualiza a lista de partidos pelo id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PoliticalPartiesDto> update(@PathVariable Long id, @RequestBody @Valid PoliticalPartiesFormDto form ) {
        Optional<PoliticalParties> politicalParties = politicalPartiesRepository.findById(id);
        return politicalParties.map(politicalPartie -> ResponseEntity.ok(modelMapper.map(politicalPartie, PoliticalPartiesDto.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //deleta os partidos pelo id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<PoliticalParties> politicalParties = politicalPartiesRepository.findById(id);
        if (politicalParties.isPresent()) {
            politicalPartiesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
