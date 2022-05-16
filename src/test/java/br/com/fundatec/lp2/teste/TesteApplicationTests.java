package br.com.fundatec.lp2.teste;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fundatec.lp2.teste.model.Pessoa;
import br.com.fundatec.lp2.teste.service.PessoaService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TesteApplicationTests {

	@Autowired
	private PessoaService pessoaService;

	@Test
	public void deveCriarUmaPessoa() {
		Pessoa lucas = new Pessoa("987654321", "lucas", LocalDate.now());

		pessoaService.criar(lucas);
		Optional<Pessoa> pessoaSalva = pessoaService.buscarCpf(lucas.getCpf());
		assertThat(pessoaSalva.get().getNome()).isEqualTo(lucas.getNome());

		pessoaService.deletar(lucas.getCpf());
	}

	@Test
	public void deveDeletarUmaPessoa() {
		Pessoa lucas = new Pessoa("987654321", "lucas", LocalDate.now());

		pessoaService.criar(lucas);
		pessoaService.deletar(lucas.getCpf());
		Optional<Pessoa> pessoaSalva = pessoaService.buscarCpf(lucas.getCpf());
		assertThat(pessoaSalva.isEmpty()).isTrue();

	}

	@Test
	public void deveListarUmaPessoa() {
		Pessoa lucas = new Pessoa("987654321", "lucas", LocalDate.now());
		Pessoa matheus = new Pessoa("123456798", "matheus", LocalDate.now());

		pessoaService.criar(lucas);
		pessoaService.criar(matheus);
		List<Pessoa> listaPessoas = pessoaService.listar();
		assertThat(listaPessoas).isNotEmpty();
		assertThat(listaPessoas.size()).isEqualTo(2);
	}

	@Test
	public void deveBuscarCpf() {
		Pessoa lucas = new Pessoa("987654321", "lucas", LocalDate.now());

		pessoaService.criar(lucas);
		Optional<Pessoa> pessoaBuscada = pessoaService.buscarCpf("987654321");
		assertThat(pessoaBuscada.isEmpty()).isFalse();
		assertThat(pessoaBuscada.get().getNome()).isEqualTo("lucas");
	}

	@Test
	public void deveAlterarPessoa() {
		Pessoa lucas = new Pessoa("987654321", "lucas", LocalDate.now());
		Pessoa matheus = new Pessoa("123456798", "matheus", LocalDate.now());

		pessoaService.criar(lucas);
		pessoaService.alterar(lucas.getCpf(), matheus);
		Optional<Pessoa> pessoaAlterada = pessoaService.buscarCpf("123456798"); //funciona se buscar pelo cpf antigo, mas da errado se buscar pelo novo
		assertThat(pessoaAlterada.get().getCpf()).isEqualTo("123456798");
		assertThat(pessoaAlterada.get().getNome()).isEqualTo("matheus");
	}
	
	
}
