package com.bzt.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.bzt.helpdesk.domain.Tecnico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.bzt.helpdesk.domain.enums.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class TecnicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	@NotNull(message = "O compo NOME é requerido")
	protected String nome;
	@NotNull(message = "O compo CPF é requerido")
	protected String cpf;
	@NotNull(message = "O compo EMAIL é requerido")
	protected String email;
	@NotNull(message = "O compo SENHA é requerido")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriação = LocalDate.now();

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis();
		this.dataCriação = obj.getDataCriação();
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
			
}
