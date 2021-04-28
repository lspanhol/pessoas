package com.lspanhol.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lspanhol.domain.exception.NegocioException;
import com.lspanhol.domain.model.Contato;
import com.lspanhol.domain.model.Pessoa;
import com.lspanhol.domain.repository.ContatoRepository;
import com.lspanhol.domain.repository.PessoaRepository;

@Service
public class GestaoContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Contato salvar(Contato contato) {
		
		Pessoa pessoa = pessoaRepository.findById(contato.getPessoa().getId()).orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
		
		contato.setPessoa(pessoa);
		
		return contatoRepository.save(contato);
	}
	
	public void excluir(Integer contatoId) {
		pessoaRepository.deleteById(contatoId);
	}
}