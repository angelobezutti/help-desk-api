package com.bzt.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import com.bzt.helpdesk.domain.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
