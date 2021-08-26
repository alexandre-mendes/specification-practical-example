package br.com.specification.entity;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.nonNull;

@AllArgsConstructor
public class ClienteSpecification implements Specification<Cliente> {

    private Boolean pessoaFisica;
    private Boolean containsPedido;
    private String nome;
    private LocalDate dataCadastro;

    @Override
    public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (TRUE.equals(pessoaFisica)) {
            predicates.add(criteriaBuilder.equal(root.get("pessoaFisica"), true));
        }

        if (TRUE.equals(containsPedido)) {
            predicates.add(criteriaBuilder.isNotEmpty(root.get("pedidos")));
        }

        if (FALSE.equals(containsPedido)) {
            predicates.add(criteriaBuilder.isEmpty(root.get("pedidos")));
        }

        if (nonNull(nome)) {
            predicates.add(criteriaBuilder.equal(root.get("nome"), nome));
        }

        if (nonNull(dataCadastro)) {
            predicates.add(criteriaBuilder.equal(root.get("dataCadastro"), dataCadastro));
        }

        return andToGether(criteriaBuilder, predicates);
    }

    public Predicate andToGether(CriteriaBuilder criteriaBuilder, List<Predicate> predicates) {
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
