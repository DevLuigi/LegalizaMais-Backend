package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.user.dto.UserResponseDTO;
import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.client.enumPersonType.PersonType;
import _bits.LegalizaMais.exception.ClientException;
import _bits.LegalizaMais.exception.UserException;
import _bits.LegalizaMais.repository.ClientRepository;
import _bits.LegalizaMais.repository.UserRepository;
import _bits.LegalizaMais.utils.CnpjValidator;
import _bits.LegalizaMais.utils.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<ClientResponseDTO> listAllByOrderByName() {
        return repository.findAllByOrderByNameAsc()
                .stream()
                .map(ClientResponseDTO::fromClient)
                .collect(Collectors.toList());
    }

    public Optional<ClientResponseDTO> listById(UUID id) {
        return repository.findById(id)
                .map(ClientResponseDTO::fromClient);
    }

    public Optional<Client> save(Client client) {
        // Documento e e-mail devem ser únicos
        if (repository.existsByEmail(client.getEmail())) {
            throw new ClientException("E-mail already registered");
        }
        if (repository.existsByDocument(client.getDocument())) {
            throw new ClientException("Document already registered");
        }

        // Validação adicional para CPF/CNPJ conforme tipo
        if (client.getPersonType() == PersonType.FISICA && !CpfValidator.isValid(client.getDocument())) {
            throw new ClientException("Invalid CPF");
        }
        if (client.getPersonType() == PersonType.JURIDICA && !CnpjValidator.isValid(client.getDocument())) {
            throw new ClientException("Invalid CNPJ");
        }

        // CEP básico
        if (!client.getCep().matches("\\d{8}")) {
            throw new ClientException("Invalid CEP format");
        }

        client.setInactive(false);
        client.setInclusionDate(LocalDateTime.now());

        return Optional.of(repository.save(client));
    }
}
