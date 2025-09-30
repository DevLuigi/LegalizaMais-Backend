package _bits.LegalizaMais.service;

import _bits.LegalizaMais.controller.ExampleController;
import _bits.LegalizaMais.domain.example.dto.ExampleResponseDTO;
import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.exception.ExampleException;
import _bits.LegalizaMais.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExampleService {
    @Autowired
    private ExampleRepository repository;

    public List<ExampleResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(ExampleResponseDTO::fromExample)
                .collect(Collectors.toList());
    }

    public Optional<Example> save(Example example) {
        if (example.getName().equals("error")) {
            throw new ExampleException("An example exception was thrown");
        }

        return Optional.of(repository.save(example));
    }
}
