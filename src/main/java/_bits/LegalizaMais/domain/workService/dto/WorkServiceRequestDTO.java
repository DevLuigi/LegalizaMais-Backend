package _bits.LegalizaMais.domain.workService.dto;

import _bits.LegalizaMais.domain.workService.entity.WorkService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WorkServiceRequestDTO {
    private UUID id;
    private String title;
    private String serviceDescription;
    private Double suggestedValue;

    public static WorkService newService(WorkServiceRequestDTO service){
        return WorkService.builder()
                .id(service.getId())
                .title(service.getTitle())
                .serviceDescription(service.getServiceDescription())
                .suggestedValue(service.getSuggestedValue())
                .build();
    }
}
