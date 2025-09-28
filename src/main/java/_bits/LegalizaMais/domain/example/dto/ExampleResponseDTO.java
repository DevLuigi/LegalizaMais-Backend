package _bits.LegalizaMais.domain.example.dto;

import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.domain.example.enumExample.Gender;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class ExampleResponseDTO {
    private UUID id;
    private String email;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Gender gender;

    public static ExampleResponseDTO fromExample(Example example) {
        return ExampleResponseDTO.builder()
                .id(example.getId())
                .email(example.getEmail())
                .name(example.getName())
                .cpf(example.getCpf())
                .birthDate(example.getBirthDate())
                .gender(example.getGender())
                .build();
    }
}