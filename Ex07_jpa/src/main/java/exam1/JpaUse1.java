package exam1;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUse1 {

	public static void main(String[] args) {
		// 자동으로 설정이 되는 거 순서를 알기 위해 한번 순서 알아보기!!
		// JPA환경 설정  //환경설정 가져오기 Persistence-unit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  
		
		// 실제 DB와 연결하여 CRUD   //환경설정 한 걸로 직접적으로 상호작용할 걸 만듬
		EntityManager em = emf.createEntityManager();  
		
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();     
		
		try {
			ts.begin();    //트랜잭션 시작 
			
			//테이블 만들기
			Member1 user = new Member1("홍길동", LocalDate.now());
			
			//.persist() 영속성으로 객체에 데이터 입력('메모리'에 insert해주는 부분)
			em.persist(user);  
			
			//db에 create table, insert해줌(// 실제 실행 user를 만들고 홍길동insert해줌)
			ts.commit();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			ts.rollback();  // 오류가 나면 롤백
		} finally {
			em.close();
		}
		emf.close();
	
	
	
	}

}
