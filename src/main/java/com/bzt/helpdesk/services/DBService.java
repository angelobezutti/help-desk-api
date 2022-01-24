package com.bzt.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzt.helpdesk.domain.Chamado;
import com.bzt.helpdesk.domain.Cliente;
import com.bzt.helpdesk.domain.Tecnico;
import com.bzt.helpdesk.domain.enums.Perfil;
import com.bzt.helpdesk.domain.enums.Prioridade;
import com.bzt.helpdesk.domain.enums.Status;
import com.bzt.helpdesk.repository.ChamadoRepository;
import com.bzt.helpdesk.repository.ClienteRepository;
import com.bzt.helpdesk.repository.TecnicoRepository;

@Service
public class DBService {
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "02397286391", "valdir@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "836287334991", "torvalds@email.com", "123");
		
		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cha1));
	}
}
