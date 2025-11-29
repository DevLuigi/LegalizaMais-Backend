package _bits.LegalizaMais.domain.workService.dto;

import _bits.LegalizaMais.domain.workService.entity.WorkService;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class WorkServiceResponseDTO {
    private UUID id;
    private String title;
    private String serviceDescription;
    private Double suggestedValue;
    private LocalDateTime inclusionDate;
    private LocalDateTime changeDate;
    private Boolean inactive;

    public static WorkServiceResponseDTO fromService(WorkService service){
        return WorkServiceResponseDTO.builder()
                .id(service.getId())
                .title(service.getTitle())
                .serviceDescription(service.getServiceDescription())
                .suggestedValue(service.getSuggestedValue())
                .inclusionDate(service.getInclusionDate())
                .changeDate(service.getChangeDate())
                .inactive(service.getInactive())
                .build();
    }
}
