package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.domain.contracts.entity.TypeContractEntity;
import _bits.LegalizaMais.exception.ClientException;
import _bits.LegalizaMais.exception.ClientNotFoundException;
import _bits.LegalizaMais.repository.TypeContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TypeContractService {
    @Autowired
    private TypeContractRepository typeContractRepository;

    public List<TypeContractEntity> listAll() {
        return typeContractRepository.findAll();
    }

    public TypeContractEntity findByName(String nameType) {
        TypeContractEntity resp = typeContractRepository.findIgnoreCase(nameType);
        return resp;
    }

    public Optional<TypeContractEntity> save(TypeContractEntity contract) {
        if (contract.getNameType().isEmpty()) {
            throw new ClientNotFoundException("O cliente informado não foi encontrado");
        }

        return Optional.of(typeContractRepository.save(contract));
    }
}
