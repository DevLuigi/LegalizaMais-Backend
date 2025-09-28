package _bits.LegalizaMais.domain.example.dto;

import _bits.LegalizaMais.domain.example.entity.Example;
import _bits.LegalizaMais.domain.example.enumExample.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleRequestDTO {
    private UUID id;
    private String email;
    private String password;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Gender gender;

    public static Example newExample(ExampleRequestDTO example) {
        return Example.builder()
                .id(example.getId())
                .email(example.getEmail())
                .password(example.getPassword())
                .name(example.getName())
                .cpf(example.getCpf())
                .birthDate(example.getBirthDate())
                .gender(example.getGender())
                .build();
    }
}
