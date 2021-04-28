package com.lspanhol.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lspanhol.domain.model.Contato;
import com.lspanhol.domain.repository.ContatoRepository;
import com.lspanhol.domain.service.GestaoContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private GestaoContatoService gestaoContatoService;
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Contato inserir(@Valid @RequestBody Contato contato) {
		return gestaoContatoService.salvar(contato);
	}
	
	@GetMapping
	public List<Contato> listar() {
		return contatoRepository.findAll();
	}
	
	@GetMapping("/{contatoId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Contato> buscar(@PathVariable Integer contatoId) {
		Optional<Contato> contato = contatoRepository.findById(contatoId);
		
		if(contato.isPresent()) {
			return ResponseEntity.ok(contato.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{contatoId}")
	public ResponseEntity<Contato> atualizar(@Valid @PathVariable Integer contatoId, @RequestBody Contato contato) {
		if(!contatoRepository.existsById(contatoId)) {
			return ResponseEntity.notFound().build();
		}
		
		contato.setId(contatoId);
		contato = gestaoContatoService.salvar(contato);
		
		return ResponseEntity.ok(contato);
	}
		
	@DeleteMapping("/{contatoId}")
	public ResponseEntity<Void> remover(@PathVariable Integer contatoId) {
		if(!contatoRepository.existsById(contatoId)) {
			return ResponseEntity.notFound().build();
		}
		
		gestaoContatoService.excluir(contatoId);
		
		return ResponseEntity.noContent().build();
	}
}