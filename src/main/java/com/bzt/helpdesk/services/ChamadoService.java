package com.bzt.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzt.helpdesk.domain.Chamado;
import com.bzt.helpdesk.repository.ChamadoRepository;
import com.bzt.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public Chamado findById(Long id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: "+ id));
	}

	public List<Chamado> findAll() {
		return (List<Chamado>) chamadoRepository.findAll();
	}

}
