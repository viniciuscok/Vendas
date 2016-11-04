package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import br.com.vendas.model.Cliente;

public class Teste 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager em = emf.createEntityManager();
		
		

		Cliente cliente = new Cliente();
		cliente.setNome("Vinicius");
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		
		System.out.println("cliente salvo com sucesso");
	}

}
