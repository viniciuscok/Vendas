package br.com.vendas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisaUsuariosBean 
{
	private List<Integer> usuarios;
	
	public PesquisaUsuariosBean()
	{
		usuarios = new ArrayList<>();
		for(int i=0; i<50; i++)
		{
			usuarios.add(i);
		}
	}

	public List<Integer> getUsuarios() {
		return usuarios;
	}
	
	
 
}