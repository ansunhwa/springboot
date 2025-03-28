package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TypedQueryLikeParameter {

	public static void main(String[] args) {
		// JPA환경 설정 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			TypedQuery<Member4> query = 
					em.createQuery("select m from Member4 m"
							+ " where m.eamil like :eamil"
							+ " order by m.name"
							, Member4.class).setParameter("eamil", "%test%");   //where의 :이름 여기와 같아야 함
			
			List<Member4> list = query.getResultList();
			
			em.getTransaction().commit();
			
			if(list.isEmpty()) {
				System.out.println("사용자가 없습니다");
			} else {
				list.forEach(user -> System.out.println(user.getName() + "/" + user.getEamil()));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		

	}

}
