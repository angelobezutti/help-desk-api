package com.bzt.helpdesk.repository;

import org.springframework.data.repository.CrudRepository;

import com.bzt.helpdesk.domain.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
}
