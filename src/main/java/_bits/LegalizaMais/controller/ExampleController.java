package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.example.dto.ExampleRequestDTO;
import _bits.LegalizaMais.domain.example.dto.ExampleResponseDTO;
import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.exception.ExampleException;
import _bits.LegalizaMais.service.ExampleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("example")
public class ExampleController {

    @Autowired
    private ExampleService service;

    @GetMapping
    public ResponseEntity<List<ExampleResponseDTO>> listAll() {
        return ResponseEntity.ok().body(service.listAll());
    }

    @PostMapping
    public ResponseEntity<ExampleResponseDTO> save(@Valid @RequestBody ExampleRequestDTO data) {
        Optional<Example> inserted = service.save(ExampleRequestDTO.newExample(data));
        if (inserted.isEmpty()) throw new ExampleException("Couldn't insert the example");

        ExampleResponseDTO response = ExampleResponseDTO.fromExample(inserted.get());
        URI location = URI.create("/example/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }
}
