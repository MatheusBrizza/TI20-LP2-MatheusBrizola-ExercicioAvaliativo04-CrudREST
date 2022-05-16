package br.com.fundatec.lp2.teste.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pessoa {

	private String cpf;
	private String nome;
	private LocalDate dataNascimento;

	public Pessoa() {
	}

	public Pessoa(String cpf, String nome, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}