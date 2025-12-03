package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.exception.ClientNotFoundException;
import _bits.LegalizaMais.service.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @GetMapping
    public ResponseEntity<List<ContractEntity>> listAll() {
        return ResponseEntity.ok().body(contractService.listAll());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<Optional<List<ContractEntity>>> listByClient(@PathVariable("clientId") Client client) {
        return ResponseEntity.ok().body(contractService.listByCliente(client));
    }

    @PostMapping
    public ResponseEntity<Optional<ContractEntity>> save(@Valid @RequestBody ContractEntity data) {
        Optional<ContractEntity> inserted = contractService.save(data);
        if (inserted.isEmpty()) throw new ClientNotFoundException("Couldn't insert the example");

        URI location = URI.create("/contract/" + inserted.get().getId());
        return ResponseEntity
                .created(location)
                .body(inserted);
    }
}
