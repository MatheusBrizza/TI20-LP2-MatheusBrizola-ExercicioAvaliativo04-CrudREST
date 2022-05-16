package br.com.fundatec.lp2.teste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/teste")
public interface TesteController {

	@GetMapping
	ResponseEntity<String> teste();
}
