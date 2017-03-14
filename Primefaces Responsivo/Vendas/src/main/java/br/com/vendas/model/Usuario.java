package br.com.vendas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private String email;
	private String senha;
	private List<Grupo> grupos;
	
	public Usuario()
	{
		this.grupos = new ArrayList<>();
	}

	
}
