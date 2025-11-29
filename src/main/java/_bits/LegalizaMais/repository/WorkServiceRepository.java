package _bits.LegalizaMais.repository;

import _bits.LegalizaMais.domain.workService.entity.WorkService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkServiceRepository extends JpaRepository<WorkService, UUID> {

    List<WorkService> findAllByOrderByInclusionDateDesc();
}
