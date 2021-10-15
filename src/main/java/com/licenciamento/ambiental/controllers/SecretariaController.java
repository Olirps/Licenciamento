package com.licenciamento.ambiental.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.licenciamento.ambiental.models.SecretariaModel;
import com.licenciamento.ambiental.repostiories.SecretariaRepository;

@Controller
public class SecretariaController {
	
	private SecretariaRepository repository;
	
	@GetMapping(path = "/api/secretaria/{secId}")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public ResponseEntity<SecretariaModel> consultar(@PathVariable("secId") Integer secId){
		if(secId==null) {
			return ResponseEntity.notFound().build();
		}
		return repository.findById(secId)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping(path = "/api/secretaria/salvar")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public SecretariaModel salvar(@RequestBody SecretariaModel secretaria) {
		repository.save(secretaria);
		return (secretaria);
	}
	

}
