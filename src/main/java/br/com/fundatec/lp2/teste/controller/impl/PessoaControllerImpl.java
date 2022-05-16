package br.com.fundatec.lp2.teste.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.lp2.teste.controller.PessoaController;
import br.com.fundatec.lp2.teste.model.Pessoa;
import br.com.fundatec.lp2.teste.service.PessoaService;

@RestController
public class PessoaControllerImpl implements PessoaController {

	private final PessoaService pessoaService;

	@Autowired
	public PessoaControllerImpl(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@Override
	public ResponseEntity<List<Pessoa>> listar() {
		return ResponseEntity.ok(pessoaService.listar());
	}
	
	@Override
	public ResponseEntity<Optional<Pessoa>> buscarCpf(String cpf) {
		return ResponseEntity.ok(pessoaService.buscarCpf(cpf));
	}

	@Override
	public ResponseEntity<Pessoa> criar(Pessoa pessoa) {
		Boolean cpfExistente = pessoaService.verificarCpf(pessoa.getCpf());
		if(cpfExistente) {
			return (ResponseEntity<Pessoa>) ResponseEntity.badRequest();
		}
		return ResponseEntity.ok(pessoaService.criar(pessoa));
	}

	@Override
	public ResponseEntity<HttpStatus> alterar(String cpf, Pessoa pessoa) {
		pessoaService.alterar(cpf, pessoa);
		return (ResponseEntity<HttpStatus>) ResponseEntity.noContent();
	}

	@Override
	public ResponseEntity<HttpStatus> excluir(String cpf) {
		pessoaService.deletar(cpf);
		return (ResponseEntity<HttpStatus>) ResponseEntity.noContent();
	}

}
