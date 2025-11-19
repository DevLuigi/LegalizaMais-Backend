package _bits.LegalizaMais.domain.user.dto;

import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.user.enumPersonType.PersonType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserResponseDTO {
    private UUID id;
    private String name;
    private PersonType personType;
    private String document;
    private int ddd;
    private String phone;
    private String email;
    private String password;
    private String cep;
    private int addressNumber;
    private String addressComplement;
    private LocalDateTime inclusionDate;
    private LocalDateTime changeDate;
    private Boolean inactive;

    public static UserResponseDTO fromUser(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .personType(user.getPersonType())
                .document(user.getDocument())
                .ddd(user.getDdd())
                .phone(user.getPhone())
                .email(user.getEmail())
                .cep(user.getCep())
                .addressNumber(user.getAddressNumber())
                .addressComplement(user.getAddressComplement())
                .inclusionDate(user.getInclusionDate())
                .changeDate(user.getChangeDate())
                .inactive(user.getInactive())
                .build();
    }
}
