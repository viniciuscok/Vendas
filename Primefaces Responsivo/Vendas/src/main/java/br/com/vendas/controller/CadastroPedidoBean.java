package br.com.vendas.controller;

import java.util.ArrayList;
import java.util.List;


//@ManagedBean
//@RequestScoped

public class CadastroPedidoBean 
{
	private List<Integer> itens;

	public CadastroPedidoBean() 
	{
		itens = new ArrayList<>();
		itens.add(1);
	}

	public List<Integer> getItens() {
		return itens;
	}


}
