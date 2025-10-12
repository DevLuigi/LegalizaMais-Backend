package _bits.LegalizaMais.domain.user.entity;

import _bits.LegalizaMais.domain.user.enumPersonType.PersonType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "tb_user")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ds_nome")
    @Size(min = 3, message = "O nome deve ter no mínimo 3 caracteres")
    @NotNull(message = "Nome deve ser preenchido")
    private String name;

    @Column(name = "tg_pessoa")
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "Tipo de pessoa deve ser preenchido")
    private PersonType personType;

    @Column(name = "ds_documento")
    @NotNull(message = "CPF/CNPJ deve ser preenchido")
    private String document;

    @Column(name = "nr_ddd")
    @NotNull(message = "DDD deve ser preenchido")
    private int ddd;

    @Column(name = "nr_telefone")
    @NotNull(message = "Número de telefone deve ser preenchido")
    private String phone;

    @Column(name = "ds_email")
    @Email @NotNull(message = "Email deve ser preenchido")
    private String email;

    @Column(name = "ds_senha")
    @NotNull(message = "Senha deve ser preenchida")
    private String password;

    @Column(name = "ds_cep")
    @NotNull(message = "CEP deve ser preenchido")
    private String cep;

    @Column(name = "nr_numero")
    @NotNull(message = "Número de endereço deve ser preenchido")
    private int addressNumber;

    @Column(name = "ds_complemento")
    @NotNull(message = "Complemento de endereço deve ser preenchido")
    private String addressComplement;

    //Campos obrigatórios
    @Column(name = "dh_inclusao", nullable = false)
    private LocalDateTime inclusionDate;

    @Column(name = "dh_alteracao")
    private LocalDateTime changeDate;

    @Column(name = "tg_inativo", nullable = false)
    private Boolean inactive;
}
