package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SelectTest {

	public static void main(String[] args) {
		// JPA환경 설정  //환경설정 가져오기 Persistence-unit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   //환경설정 한 걸로 직접적으로 상호작용할 걸 만듬
		EntityManager em = emf.createEntityManager();  	//관리 - em.getTransaction();
		
		/*
		 *  검색 시 find() 메소드 사용
		 	- test@test.com(fk)를 찾아서 Member3에 담아서 가지고 오려고 함
		 	  > find뒤에 아무것도 붙이지 않으면 @Id(fk)가 붙은 필드에서 검색(한행 가져옴
		 */
		Member3 user = em.find(Member3.class, "test@test.com");   // m3에 user에 담는다 = m3.class에 있는 test@를
		System.out.println(user);
		
		if(user != null) {
			System.out.println("이름 : " + user.getName());
			System.out.println("email : " + user.getEamil());
			System.out.println("날짜 : " + user.getCreateDate());
		}else {
			System.out.println("존재하지 않는 아이디 입니다");
		}
		em.close();
		emf.close();
				
	}

}
