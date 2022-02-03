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
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "966.034.230-65", "valdir@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Jonson Augusto", "717.799.490-49", "jonson@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec3 = new Tecnico(null, "André Saveiro", "606.640.680-90", "saveiro@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "257.052.820-01", "torvalds@email.com", "123");
		Cliente cli2 = new Cliente(null, "Carlos Nelol", "694.015.830-80", "nelol@email.com", "123");
		Cliente cli3 = new Cliente(null, "João Pinheiro", "611.283.210-09", "pinheiro@email.com", "123");
		
		Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado cha2 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 02", "Segundo Chamado", tec2, cli2);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		tecnicoRepository.saveAll(Arrays.asList(tec3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		clienteRepository.saveAll(Arrays.asList(cli2));
		clienteRepository.saveAll(Arrays.asList(cli3));
		chamadoRepository.saveAll(Arrays.asList(cha1));
		chamadoRepository.saveAll(Arrays.asList(cha2));
	}
}
