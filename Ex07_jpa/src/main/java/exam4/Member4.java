package exam4;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="JpaMember4")
public class Member4 {
	@Id
	private String eamil;
	
	private String name;
	
	@Column(name="create_date")  //실제db에표시
	private LocalDate createDate;
	
	public Member4() {		
	}

	public Member4(String eamil, String name, LocalDate createDate) {
		this.eamil = eamil;
		this.name = name;
		this.createDate = createDate;
	}

	public String getEamil() {
		return eamil;
	}

	public String getName() {
		return name;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}
	
	/*
	public void changeName(String newName) {
		this.name = newName;
	}
	*/
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member3 [eamil=" + eamil + ", name=" + name + ", createDate=" + createDate + "]";
	}
	
	
	


}


