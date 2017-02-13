package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidoPU");
		EntityManager em = emf.createEntityManager();
		
		

		//Cliente cliente = new Cliente();
		//cliente.setNome("Vinicius");
		//em.getTransaction().begin();
		//em.persist(cliente);
		//em.getTransaction().commit();
		
		String documento = "059.200.315-91";
		
		String documentos = em.createQuery("select c.documento from Cliente c where c.documento = ?1", String.class)
				.setParameter(1, documento).getSingleResult();
		
		//for (String cliente : documentos) {
			//System.out.println("Documeto "+cliente.getDocumento());
	//	}
		
		System.out.println(documentos);
		
		
	}

}
