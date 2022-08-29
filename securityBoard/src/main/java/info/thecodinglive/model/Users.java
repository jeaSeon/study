package info.thecodinglive.model;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String roleType;	//권한(롤)
	
	@CreationTimestamp
	private Timestamp createDate;	//가입일       


	
	
}
