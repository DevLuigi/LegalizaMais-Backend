package _bits.LegalizaMais.service;

import _bits.LegalizaMais.domain.client.dto.ClientResponseDTO;
import _bits.LegalizaMais.domain.workService.dto.WorkServiceResponseDTO;
import _bits.LegalizaMais.domain.workService.entity.WorkService;
import _bits.LegalizaMais.repository.WorkServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkServiceService {

    @Autowired
    WorkServiceRepository repository;

    public List<WorkServiceResponseDTO> listAllServices(){
        return repository.findAllByOrderByInclusionDateDesc()
                .stream()
                .map(WorkServiceResponseDTO::fromService)
                .collect(Collectors.toList());
    }

    public Optional<WorkService> save(WorkService service){
        service.setInclusionDate(LocalDateTime.now());
        service.setChangeDate(null);
        service.setInactive(false);

        return Optional.of(repository.save(service));
    }
}
