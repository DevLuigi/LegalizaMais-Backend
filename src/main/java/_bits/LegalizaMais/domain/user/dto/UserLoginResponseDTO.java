package _bits.LegalizaMais.domain.user.dto;

import _bits.LegalizaMais.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class UserLoginResponseDTO {
    private UUID id;
    private String email;

    public static UserLoginResponseDTO fromUser(User user) {
        return UserLoginResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
