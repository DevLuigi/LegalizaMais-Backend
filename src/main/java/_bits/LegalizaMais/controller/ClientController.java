package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.client.dto.ClientRequestDTO;
import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.dto.UserRequestDTO;
import _bits.LegalizaMais.domain.user.dto.UserResponseDTO;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.exception.ExampleException;
import _bits.LegalizaMais.service.ClientService;
import _bits.LegalizaMais.service.UserService;
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
        if (inserted.isEmpty()) throw new ExampleException("Couldn't insert the user");

        ClientResponseDTO response = ClientResponseDTO.fromClient(inserted.get());
        URI location = URI.create("/client/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }
}
