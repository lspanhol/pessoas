package com.lspanhol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lspanhol.domain.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
