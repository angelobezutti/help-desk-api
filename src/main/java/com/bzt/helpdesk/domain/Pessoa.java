package com.bzt.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public abstract class Pessoa {
	protected Long id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
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
