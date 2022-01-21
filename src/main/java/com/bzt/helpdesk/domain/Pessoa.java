package com.bzt.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public abstract class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	protected String nome;
	
	@Column(unique = true)
	protected String cpf;
	
	@Column(unique = true)
	protected String email;
	protected String senha;
	
	@ElementCollection(fetch = FetchType.EAGER) @CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriação = LocalDate.now();
	
	public Pessoa(Long id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	
}
