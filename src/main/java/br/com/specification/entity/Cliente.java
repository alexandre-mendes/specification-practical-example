package br.com.specification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente implements Serializable {

    @Id
    private Long id;

    private String nome;

    private Boolean pessoaFisica;

    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Pedido> pedidos;

}
