package br.com.specification.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cliente implements Serializable {

    @Id
    private Long id;

    private String nome;

    private Boolean pessoaFisica;

    private LocalDate dataCadastro;
}
