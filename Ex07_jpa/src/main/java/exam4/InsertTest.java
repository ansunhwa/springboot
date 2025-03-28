package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class InsertTest {

	public static void main(String[] args) {
		// JPA환경 설정 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			Member4 user;
			user = new Member4("test1@test.com", "홍길동", LocalDate.now());   
			em.persist(user);   //그냥 쓰면 덮어쓰기 되기 때문에 영속성안에 넣어둠
			
			user = new Member4("test2@test.com", "김파랑", LocalDate.now());
			em.persist(user);
			
			user = new Member4("test3@test.com", "최노랑", LocalDate.now());
			em.persist(user);
			
			user = new Member4("test4@test.com", "이분홍", LocalDate.now());
			em.persist(user);
			
			user = new Member4("tes5t@test.com", "박초록", LocalDate.now());
			em.persist(user);
			
			user = new Member4("tes6t@test.com", "김검정", LocalDate.now());
			em.persist(user);
			
			user = new Member4("test7@test.com", "홍연두", LocalDate.now());
			em.persist(user);
			
			user = new Member4("test8@test.com", "오렌지", LocalDate.now());
			em.persist(user);
			
			em.getTransaction().commit();
			System.out.println("가입요청을 처리했습니다");
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		

	}

}
