package _bits.LegalizaMais.domain.user.dto;

import _bits.LegalizaMais.domain.user.entity.User;
import _bits.LegalizaMais.domain.user.enumPersonType.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
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

    public static User newUser(UserRequestDTO user){
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .personType(user.getPersonType())
                .document(user.getDocument())
                .ddd(user.getDdd())
                .phone(user.getPhone())
                .email(user.getEmail())
                .password(user.getPassword())
                .cep(user.getCep())
                .addressNumber(user.getAddressNumber())
                .addressComplement(user.getAddressComplement())
                .build();
    }
}
