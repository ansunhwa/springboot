package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;  //이름이 같아야 함

public class TypedQuery {

	public static void main(String[] args) {
		// JPA환경 설정 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   
		EntityManager em = emf.createEntityManager();
		
		/*
		 * TypedQuery 클래스 : sql문을 직접 작성하고자 할 때
		   - 일반 sql문법이 아닌 영속성의 객체에 넣을 구문 jpa문법
		     > select * => *을 사용할 수 없음. 테이블의 별칭을 이용하여 사용
		 */
		
		try {
			em.getTransaction().begin();
		Query query = em.createQuery("select m from Member4 m order by m.name", Member4.class);
		
		List<Member4> list = query.getResultList();
		
		em.getTransaction().commit();
		
		if(list.isEmpty()) {
			System.out.println("테이블이 비어 있습니다");
		}else {
			list.forEach(user -> System.out.print(user.getEamil() + "/" + user.getName()));
		}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
	}

}
