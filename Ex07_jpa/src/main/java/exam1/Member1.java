package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="JpaMember1")  //jakarta
public class Member1 {
	@Id
	@GeneratedValue
	private Long id;   // int : 기본값 0
	                   // Long : null
	
	private String username;
	
	@Column(name="create_date")       //데이터베이스에는 이 필드명으로 넣겠따
	private LocalDate createDate;  // 날짜가져오기  여기선 createDate라고 사용하고
	
	//빈생성자는 반드시 필요!!!
	public Member1() {   
	}

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}
/* JPA에서 쓰는 어노테이션
 * @Entitiy : 해당 클래스가 JPA의 엔티티임을 의미(테이블 매핑된 JPA)
 * @Table(name="이름") : 실제 DB에 행성될 테이블 이름 만약, 이 어노테이션이 없으면 클래스의 이름이 테이블 이름이 됨
 * @Id : primary key
 * @GeneratedValue : sequence를 이용함
 * @Cloumn(name="이름") : 실제 테이블의 속성명을 이 이름으로 함
 */
