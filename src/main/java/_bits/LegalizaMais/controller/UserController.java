package _bits.LegalizaMais.controller;

import _bits.LegalizaMais.domain.example.dto.ExampleRequestDTO;
import _bits.LegalizaMais.domain.example.dto.ExampleResponseDTO;
import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.domain.user.dto.UserRequestDTO;
import _bits.LegalizaMais.domain.user.dto.UserResponseDTO;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.exception.ExampleException;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listAllByOrderByName() {
        return ResponseEntity.ok().body(service.listAllByOrderByName());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserResponseDTO>> listById(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok().body(service.listById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserRequestDTO data) {
        Optional<User> inserted = service.save(UserRequestDTO.newUser(data));
        if (inserted.isEmpty()) throw new ExampleException("Couldn't insert the user");

        UserResponseDTO response = UserResponseDTO.fromUser(inserted.get());
        URI location = URI.create("/user/" + response.getId());
        return ResponseEntity
                .created(location)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO user) {
        UserResponseDTO response = service.login(user);
        return response == null ? ResponseEntity.notFound().build() : ResponseEntity.ok().body(response);
    }
}
