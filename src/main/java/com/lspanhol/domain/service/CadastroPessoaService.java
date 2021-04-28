package com.lspanhol.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lspanhol.domain.exception.NegocioException;
import com.lspanhol.domain.model.Pessoa;
import com.lspanhol.domain.repository.PessoaRepository;

@Service
public class CadastroPessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvar(Pessoa pessoa) {
		Pessoa pessoaExistente = pessoaRepository.findByCpf(pessoa.getCpf());
		
		if(pessoaExistente != null && !pessoaExistente.equals(pessoa)) {
			throw new NegocioException("Já existe uma pessoa com este CPF.");
		}
		
		pessoa.getContatos().forEach(contato -> contato.setPessoa(pessoa));
		
		return pessoaRepository.save(pessoa);
	}
	
	public void excluir(Integer pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
}
