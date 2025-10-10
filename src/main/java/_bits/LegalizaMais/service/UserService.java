package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.domain.user.dto.UserResponseDTO;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.user.enumPersonType.PersonType;
import _bits.LegalizaMais.exception.ExampleException;
import _bits.LegalizaMais.exception.UserException;
import _bits.LegalizaMais.repository.ExampleRepository;
import _bits.LegalizaMais.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public List<UserResponseDTO> listAllByOrderByName() {
        return repository.findAllByOrderByNameAsc()
                .stream()
                .map(UserResponseDTO::fromUser)
                .collect(Collectors.toList());
    }

    public Optional<User> save(User user) {
        // Documento e e-mail devem ser únicos
        if (repository.existsByEmail(user.getEmail())) {
            throw new UserException("E-mail already registered");
        }
        if (repository.existsByDocument(user.getDocument())) {
            throw new UserException("Document already registered");
        }

        // Validação adicional para CPF/CNPJ conforme tipo
        if (user.getPersonType() == PersonType.FISICA && !isValidCPF(user.getDocument())) {
            throw new UserException("Invalid CPF");
        }
        if (user.getPersonType() == PersonType.JURIDICA && !isValidCNPJ(user.getDocument())) {
            throw new UserException("Invalid CNPJ");
        }

        // CEP básico
        if (!user.getCep().matches("\\d{8}")) {
            throw new UserException("Invalid CEP format");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        user.setInactive(false);
        user.setInclusionDate(LocalDateTime.now());

        return Optional.of(repository.save(user));
    }

    private boolean isValidCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    private boolean isValidCNPJ(String cnpj) {
        return cnpj != null && cnpj.matches("\\d{14}");
    }
}
