package exam3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertTest {

	public static void main(String[] args) {
		// JPA환경 설정  //환경설정 가져오기 Persistence-unit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   //환경설정 한 걸로 직접적으로 상호작용할 걸 만듬
		EntityManager em = emf.createEntityManager();  		
		// 트랜잭션 관리
		//EntityTransaction ts = em.getTransaction();  바로 쓰면 이거 안해도 되긴 해
		
		try {
			em.getTransaction().begin();
			
			Member3 user = new Member3("test@test.com", "홍길동", LocalDate.now());
			System.out.println("1 : ");
			
			em.persist(user);  //데이터에 넣음
			System.out.println("2 : ");
			
			em.getTransaction().commit();
			System.out.println("3 : ");
			System.out.println("가입 요청을 처리했습니다");
			
		} catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		} 
		em.close();
		emf.close();
		

	}

}
