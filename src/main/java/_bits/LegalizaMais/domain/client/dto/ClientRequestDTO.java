package _bits.LegalizaMais.domain.client.dto;

import _bits.LegalizaMais.domain.client.entity.Client;
import _bits.LegalizaMais.domain.client.enumPersonType.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {
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

    public static Client newClient(ClientRequestDTO client){
        return Client.builder()
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
                .build();
    }
}