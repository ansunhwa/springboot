package exam2;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="JpaMember2")
public class Member2 {
	@Id
	@SequenceGenerator(
		name="mySequence",   // 시퀀스 별칭
		sequenceName = "JpaMember2_seq",   // 실제 DB에만들어지는 시퀀스 이름
		initialValue = 1, // 초기값
		allocationSize = 1  //몇식증가
	)
	@GeneratedValue(generator = "mySequence")  // 만든시퀀스는 id를 만들때 정한 것과 동일하게
	private Long id;
	
	@Access(AccessType.FIELD)  // 기본값, 필드를 통해서 데이터에 접근(접근 시 getset 안쓰고 
	private String username;   
	
	@Access(AccessType.PROPERTY)   //get,set메소드를 통해 데이터 접근!!
	private String password; 
	
	@Transient
	private long timestamp1;  // 어노테이션을 이용해 영속대상(db)에서 제외  //필드생성X
	transient private long timestamp2;  // 키워드를 이용해 영속대상(db)에서 제외
	
	public Member2() {  //무조건 있어야 함!
	}

	public Member2(String username, String password) {  //받아 올 값
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
