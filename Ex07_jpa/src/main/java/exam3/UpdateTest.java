package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UpdateTest {

	public static void main(String[] args) {
		// JPA환경 설정 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEx01");  				
		// 실제 DB와 연결하여 CRUD   
		EntityManager em = emf.createEntityManager();  	//관리 - em.getTransaction();
		
		try {
			em.getTransaction().begin();
			
			
			Member3 user = em.find(Member3.class, "test@test.com");  //test인 한행을 M3dptj 찾아서 user에 넣음(한행가져옴)
			if(user == null) {
				System.out.println("존재하지 않는 아이디 입니다");
				return;
			}
			
			user.setName("다람이");
			
			em.getTransaction().commit();
			System.out.println("이름이 변경되었습니다");
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();
		
	}

}
