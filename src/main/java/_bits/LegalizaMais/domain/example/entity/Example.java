package _bits.LegalizaMais.domain.example.entity;

import _bits.LegalizaMais.domain.example.enumExample.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "Example")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Example {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Email @NotNull(message = "Email deve ser preenchido")
    private String email;

    @NotNull(message = "Senha deve ser preenchida")
    private String password;

    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    @NotNull(message = "Nome deve ser preenchido")
    private String name;

    @NotNull(message = "CPF deve ser preenchido")
    private String cpf;

    @NotNull(message = "Data de nascimento deve ser preenchida")
    @Past(message = "Data de nascimento deve estar no passado")
    private LocalDate birthDate;

    @NotNull(message = "Gênero deve ser preenchido")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}
