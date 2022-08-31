package info.thecodinglive.model;


//회원 엔티티이다.
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;				//순서. 자동증가
	private String username;	//아이디
	private String password;	//패스워드
	private String email;		//이메일
	private String roleType;	//권한(USER, MANAGER, ADMIN)
	
	@CreationTimestamp
	private Timestamp createDate;	//가입일 


	
	
}
