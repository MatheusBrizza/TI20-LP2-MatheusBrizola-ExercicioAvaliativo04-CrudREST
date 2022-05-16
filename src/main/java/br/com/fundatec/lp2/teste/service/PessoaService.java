package br.com.fundatec.lp2.teste.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fundatec.lp2.teste.model.Pessoa;
import br.com.fundatec.lp2.teste.repository.PessoaRepository;
import br.com.fundatec.lp2.teste.repository.impl.PessoaRepositoryImpl;

@Service
public class PessoaService {

	private final PessoaRepository pessoaRepository;

	public PessoaService() {
		this.pessoaRepository = new PessoaRepositoryImpl();
	}

	public List<Pessoa> listar() {
		return pessoaRepository.listar();
	}
	
	public Optional<Pessoa> buscarCpf(String cpf) {
		return pessoaRepository.buscarPorCpf(cpf);
	}

	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.criar(pessoa);
	}
	
	public Boolean verificarCpf(String cpf) {
		Boolean flag = false;
		Optional<Pessoa> verificarCpf = pessoaRepository.buscarPorCpf(cpf);
		if(verificarCpf.isPresent()) {
			flag = true;
			throw new RuntimeException("Já existe uma pessoa com o CPF informado");
		}
		return flag;
	}
	
	public void alterar(String cpf, Pessoa pessoaNova) {
		pessoaRepository.alterar(cpf, pessoaNova);
	}
	
	public void deletar(String cpf) {
		pessoaRepository.deletar(cpf);
	}
}
