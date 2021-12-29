package Avaliacao.Sprint4.PartidosPoliticos.Controller;

import Avaliacao.Sprint4.PartidosPoliticos.Controller.dto.AssociatesDto;
import Avaliacao.Sprint4.PartidosPoliticos.Controller.dto.AssociatesFormDto;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.Associates;
import Avaliacao.Sprint4.PartidosPoliticos.Entity.PoliticalOffice;
import Avaliacao.Sprint4.PartidosPoliticos.repository.AssociatesRepository;
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
@RequestMapping("/associados")
public class AssociatesController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AssociatesRepository associatesRepository;

    //cadastrar associados
    @PostMapping
    @Transactional
    public ResponseEntity<AssociatesDto> register(@RequestBody @Valid AssociatesFormDto form, UriComponentsBuilder uriBuilder) {
        Associates associates = modelMapper.map(form, Associates.class);
        associatesRepository.save(associates);

        URI uri = uriBuilder.path(("/associados")).buildAndExpand(associates.getId()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(associates, AssociatesDto.class));
    }

    //Lista os associados com filtro por cargo político
    @GetMapping
    public List<AssociatesDto> listByFilter(@RequestParam(required = false) PoliticalOffice politicalOffice) {
        if (politicalOffice == null) {
            List<Associates> associates = associatesRepository.findAll();
            return associates.stream().map(associate -> modelMapper.map(associate, AssociatesDto.class)).collect(Collectors.toList());
        }else {
            List<Associates> associates = associatesRepository.findByPoliticalOffice(politicalOffice);
            return associates.stream().map(associate -> modelMapper.map(associate, AssociatesDto.class)).collect(Collectors.toList());
        }
    }

    //Lista os associados referenciado ao id
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociatesDto> search(@PathVariable Long id) {
        Optional<Associates> associate = associatesRepository.findById(id);
        return associate.map(associates -> ResponseEntity.ok(modelMapper.map(associates, AssociatesDto.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //atualiza a lista de associados pelo id
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AssociatesDto> update(@PathVariable Long id, @RequestBody @Valid AssociatesFormDto form ) {
        Optional<Associates> optional = associatesRepository.findById(id);
        return optional.map(associates -> ResponseEntity.ok(modelMapper.map(associates, AssociatesDto.class))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //deleta os associados pelo id
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Associates> optional = associatesRepository.findById(id);
        if (optional.isPresent()) {
            associatesRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
