package br.com.fundatec.lp2.teste.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.lp2.teste.model.Pessoa;

@RequestMapping("/api/pessoas")
@RestController
public interface PessoaController {

	@GetMapping
	ResponseEntity<List<Pessoa>> listar();

	@GetMapping("/{cpf}")
	ResponseEntity<Optional<Pessoa>> buscarCpf(@PathVariable("cpf") String cpf);

	@PostMapping()
	ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa);

	@PutMapping("/{cpf}")
	ResponseEntity<HttpStatus> alterar(@PathVariable("cpf") String cpf, @RequestBody Pessoa pessoa);

	@DeleteMapping("/{cpf}")
	ResponseEntity<HttpStatus> excluir(@PathVariable("cpf") String cpf);

}
