package com.licenciamento.ambiental.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.licenciamento.ambiental.models.ProcessoModel;
import com.licenciamento.ambiental.repostiories.ProcessoRepository;

public class ProcessoController {
	
	private ProcessoRepository repository;
	
	@GetMapping(path = "/api/processo/{procId}")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public ResponseEntity<ProcessoModel> consultar(@PathVariable("secId") Integer procId){
		if(procId==null) {
			return ResponseEntity.notFound().build();
		}
		return repository.findById(procId)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping(path = "/api/processo/salvar")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
	public ProcessoModel salvar(@RequestBody ProcessoModel processo) {
		repository.save(processo);
		return (processo);
	}

}
