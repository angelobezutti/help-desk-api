package com.bzt.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzt.helpdesk.domain.Tecnico;
import com.bzt.helpdesk.repository.TecnicoRepository;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	public Tecnico findById(Long id) {
		Optional<Tecnico> obj = tecnicoRepository.findById(id);
		return obj.orElse(null);
	}
}
