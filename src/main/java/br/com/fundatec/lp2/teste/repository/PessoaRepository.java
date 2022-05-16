package br.com.fundatec.lp2.teste.repository;

import java.util.List;
import java.util.Optional;

import br.com.fundatec.lp2.teste.model.Pessoa;

public interface PessoaRepository {
	// get
	List<Pessoa> listar();

	// get{cpf}
	Optional<Pessoa> buscarPorCpf(String cpf);

	// post
	Pessoa criar(Pessoa pessoa);
	
	// alterar
	Pessoa alterar(String cpf, Pessoa pessoa);

	// delete
	void deletar(String cpf);
}
