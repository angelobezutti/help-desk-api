package com.bzt.helpdesk.domain;

import java.time.LocalDate;

import com.bzt.helpdesk.domain.enums.Prioridade;
import com.bzt.helpdesk.domain.enums.Status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Chamado {
	private Long id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	private Tecnico tecnico;
	private Cliente cliente;
	
	public Chamado(Long id, Prioridade prioridade, Status status, String titulo, String observacoes, Tecnico tecnico, Cliente cliente) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}
}
