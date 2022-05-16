package br.com.fundatec.lp2.teste.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import br.com.fundatec.lp2.teste.model.Pessoa;
import br.com.fundatec.lp2.teste.repository.PessoaRepository;

public class PessoaRepositoryImpl implements PessoaRepository {

	private static final Map<String, Pessoa> PESSOAS = new HashMap<>();

	@Override
	public List<Pessoa> listar() {
		return new ArrayList<>(PESSOAS.values());
	}

	@Override
	public Optional<Pessoa> buscarPorCpf(String cpf) {
		return Optional.ofNullable(PESSOAS.get(cpf));
	}

	@Override
	public Pessoa criar(Pessoa pessoa) {
		return PESSOAS.put(pessoa.getCpf(), pessoa);
	}

	@Override
	public void deletar(String cpf) {
		PESSOAS.remove(cpf);
	}

	@Override
	public Pessoa alterar(String cpf, Pessoa pessoa) {
		Pessoa pessoaNova = PESSOAS.replace(cpf, pessoa);
		return pessoaNova;
	}

}
