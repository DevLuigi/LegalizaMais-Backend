package _bits.LegalizaMais.domain.client.dto;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.client.enumPersonType.PersonType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ClientResponseDTO {
    private UUID id;
    private String name;
    private PersonType personType;
    private String document;
    private int ddd;
    private String phone;
    private String email;
    private String cep;
    private int addressNumber;
    private String addressComplement;
    private LocalDateTime inclusionDate;
    private LocalDateTime changeDate;
    private Boolean inactive;
    
    public static ClientResponseDTO fromClient(Client client){
        return ClientResponseDTO.builder()
                .id(client.getId())
                .name(client.getName())
                .personType(client.getPersonType())
                .document(client.getDocument())
                .ddd(client.getDdd())
                .phone(client.getPhone())
                .email(client.getEmail())
                .cep(client.getCep())
                .addressNumber(client.getAddressNumber())
                .addressComplement(client.getAddressComplement())
                .inclusionDate(client.getInclusionDate())
                .changeDate(client.getChangeDate())
                .inactive(client.getInactive())
                .build();
    }
}
