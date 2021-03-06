package br.com.specification.controller;

import br.com.specification.entity.Cliente;
import br.com.specification.entity.ClienteSpecification;
import br.com.specification.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> obterTodos(
        @RequestParam(name = "pessoaFisica", required = false) Boolean pessoaFisica,
        @RequestParam(name = "containsPedido", required = false) Boolean containsPedido,
        @RequestParam(name = "nome", required = false) String nome,
        @RequestParam(name = "dataCadastro", required = false) LocalDate dataCadastro
        ) {
        ClienteSpecification specification = new ClienteSpecification(pessoaFisica, containsPedido, nome, dataCadastro);
        return clienteRepository.findAll(specification);
    }
}
