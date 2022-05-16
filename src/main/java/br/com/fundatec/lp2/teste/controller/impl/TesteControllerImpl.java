package br.com.fundatec.lp2.teste.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.fundatec.lp2.teste.controller.TesteController;
import br.com.fundatec.lp2.teste.service.TesteService;

@RestController
public class TesteControllerImpl implements TesteController{

	private final TesteService service;
	
	@Autowired
	public TesteControllerImpl(TesteService service) {
		this.service = service;
	}
	
	@Override
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok(service.teste());
	}

}
