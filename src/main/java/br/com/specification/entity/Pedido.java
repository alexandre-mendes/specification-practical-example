package br.com.specification.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {

    @Id
    private Long id;

    private Integer numeroPedido;

    @JsonIgnore
    @ManyToOne
    private Cliente cliente;
}
