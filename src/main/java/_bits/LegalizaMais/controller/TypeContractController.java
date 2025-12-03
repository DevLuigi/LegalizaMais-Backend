package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.domain.contracts.entity.TypeContractEntity;
import _bits.LegalizaMais.exception.ClientNotFoundException;
import _bits.LegalizaMais.service.TypeContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("typeContract")
public class TypeContractController {
    @Autowired
    private TypeContractService typeContractService;

    @GetMapping
    public ResponseEntity<List<TypeContractEntity>> listAll() {
        return ResponseEntity.ok().body(typeContractService.listAll());
    }

    @GetMapping("/nomeTipo")
    public ResponseEntity<TypeContractEntity> findByNameType(@RequestParam String nameType) {
        return ResponseEntity.ok(typeContractService.findByName(nameType));
    }

    @PostMapping
    public ResponseEntity<Optional<TypeContractEntity>> save(@Valid @RequestBody TypeContractEntity data) {
        Optional<TypeContractEntity> inserted = typeContractService.save(data);
        if (inserted.isEmpty()) throw new ClientNotFoundException("Couldn't insert the example");

        return ResponseEntity.ok(inserted);
    }
}
