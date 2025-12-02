package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.client.dto.ClientRequestDTO;
import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.exception.ClientException;
import _bits.LegalizaMais.exception.UserException;
import _bits.LegalizaMais.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> listAllByOrderByName() {
        return ResponseEntity.ok().body(service.listAllByOrderByName());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<ClientResponseDTO>> listById(@PathVariable("clientId") UUID id) {
        return ResponseEntity.ok().body(service.listById(id));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(@Valid @RequestBody ClientRequestDTO data) {
        Optional<Client> inserted = service.save(ClientRequestDTO.newClient(data));
        if (inserted.isEmpty()) throw new ClientException("Couldn't insert the user");

        ClientResponseDTO response = ClientResponseDTO.fromClient(inserted.get());
        URI location = URI.create("/client/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientResponseDTO> updateById(@PathVariable("clientId") UUID id, @Valid @RequestBody ClientRequestDTO data) {
        Optional<Client> user = service.updateById(id, data);

        ClientResponseDTO response = ClientResponseDTO.fromClient(user.get());
        URI location = URI.create("/client/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }

    @Transactional
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable("clientId") UUID clientId) {
        boolean deleted = service.deleteClient(clientId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}
