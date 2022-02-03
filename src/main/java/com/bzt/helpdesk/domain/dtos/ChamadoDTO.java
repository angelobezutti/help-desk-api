package com.bzt.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.bzt.helpdesk.domain.Chamado;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor 
public class ChamadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	@NotNull(message = "O compo PRIORIDADE é requerido")
	private Integer prioridade;
	@NotNull(message = "O compo STATUS é requerido")
	private Integer status;
	@NotNull(message = "O compo TITULO é requerido")
	private String titulo;
	@NotNull(message = "O compo OBSERVAÇÕES é requerido")
	private String observacoes;
	@NotNull(message = "O compo TÉCNICO é requerido")
	private Long tecnico;
	@NotNull(message = "O compo CLIENTE é requerido")
	private Long cliente;
	private String nomeTecnico;
	private String nomeCliente;
	
	public ChamadoDTO(Chamado obj) {
		super();
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeTecnico = obj.getTecnico().getNome();
		this.nomeCliente = obj.getCliente().getNome();
	}
	
	
	
}
