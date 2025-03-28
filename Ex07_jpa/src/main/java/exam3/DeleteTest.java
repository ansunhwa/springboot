package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DeleteTest {

	public static void main(String[] args) {
		// JPA환경 설정 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Member3 user = em.find(Member3.class, "test@test.com");
			if(user==null) {
				System.out.println("존재하지 않는 아이디 이니다");
				return;
			}
			em.remove(user);  //영속성에서 객체 삭제(ORM하이버네이트에서)
			
			em.getTransaction().commit(); //(실제삭제)
			System.out.println("탈퇴처리 되었습니다");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		em.close();
		emf.close();
		
		
	}

}
