package com.bzt.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzt.helpdesk.domain.Chamado;
import com.bzt.helpdesk.domain.Cliente;
import com.bzt.helpdesk.domain.Tecnico;
import com.bzt.helpdesk.domain.dtos.ChamadoDTO;
import com.bzt.helpdesk.domain.enums.Prioridade;
import com.bzt.helpdesk.domain.enums.Status;
import com.bzt.helpdesk.repository.ChamadoRepository;
import com.bzt.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Long id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado: "+ id));
	}

	public List<Chamado> findAll() {
		return (List<Chamado>) chamadoRepository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return chamadoRepository.save(newChamado(objDTO)); 
				
	}
	
	public Chamado update(Long id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return chamadoRepository.save(oldObj);
	}
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if (obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		
		if (obj.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getPrioridade()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
	}

}
