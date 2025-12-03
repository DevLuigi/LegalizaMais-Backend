package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.budget.entity.Budget;
import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.client.enumPersonType.PersonType;
import _bits.LegalizaMais.domain.contracts.entity.ContractEntity;
import _bits.LegalizaMais.domain.contracts.entity.TypeContractEntity;
import _bits.LegalizaMais.exception.ClientException;
import _bits.LegalizaMais.exception.ClientNotFoundException;
import _bits.LegalizaMais.repository.BudgetRepository;
import _bits.LegalizaMais.repository.ClientRepository;
import _bits.LegalizaMais.repository.ContractRepository;
import _bits.LegalizaMais.repository.TypeContractRepository;
import _bits.LegalizaMais.utils.CnpjValidator;
import _bits.LegalizaMais.utils.CpfValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContractService {
    @Autowired
    private ContractRepository repository;

    @Autowired
    private TypeContractRepository typeContractRepository;

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<ContractEntity> listAll() {
        return repository.findAll();
    }

    public Optional<List<ContractEntity>> listByCliente(Client client) {
        return repository.findByClient(client);
    }

    public Optional<ContractEntity> save(ContractEntity contract) {
        if (!typeContractRepository.existsById(contract.getTypeContract().getId())) {
            throw new ClientException("O tipo de contrato informado não foi encontrado");
        }
        if (!budgetRepository.existsById(contract.getBudget().getId())) {
            throw new ClientException("O orcamento informado não foi encontrado");
        }
        if (!clientRepository.existsById(contract.getClient().getId())) {
            throw new ClientNotFoundException("O cliente informado não foi encontrado");
        }

        return Optional.of(repository.save(contract));
    }
}
