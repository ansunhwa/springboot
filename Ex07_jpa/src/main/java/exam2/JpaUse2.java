package exam2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse2 {

	public static void main(String[] args) {
		// JPA환경 설정  //환경설정 가져오기 Persistence-unit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  
				
		// 실제 DB와 연결하여 CRUD   //환경설정 한 걸로 직접적으로 상호작용할 걸 만듬
		EntityManager em = emf.createEntityManager();  
				
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();   
		
		try {
		ts.begin();  //시작
		Member2 user = new Member2("김파랑","1234");		
		em.persist(user); //.persist() 영속성으로 객체에 데이터 입력('메모리'에 insert해주는 부분)		
		ts.commit();  //실제로 insert
		
		} catch(Exception e){
			e.printStackTrace();
			ts.rollback();
		} finally {
			em.close();
		}
		emf.close();
		
	}

}
