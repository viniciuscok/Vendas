package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.vendas.model.Clientee;

public class Teste 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CadastroPu");
		EntityManager manager = factory.createEntityManager();
		
		

		Clientee clientee = new Clientee();
		clientee.setNome("João das Couves");
		
		manager.getTransaction().begin();
		manager.persist(clientee);
		manager.getTransaction().commit();
		
		System.out.println("cliente salvo com sucesso");
	}

}
