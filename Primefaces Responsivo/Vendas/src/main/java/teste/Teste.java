package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import br.com.vendas.model.Cliente;

public class Teste 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VendasPU");
		EntityManager em = emf.createEntityManager();
		
		

		Cliente clientee = new Cliente();
		clientee.setNome("Vinicius");
		em.getTransaction().begin();
		em.persist(clientee);
		em.getTransaction().commit();
		
		
		System.out.println("cliente salvo com sucesso");
	}

}
