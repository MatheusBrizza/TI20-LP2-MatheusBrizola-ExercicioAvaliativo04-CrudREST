package br.com.fundatec.lp2.teste.service;

import org.springframework.stereotype.Service;

@Service
public class TesteService {

	public String teste() {
		return "API works via service inversão de controle";
	}
}
